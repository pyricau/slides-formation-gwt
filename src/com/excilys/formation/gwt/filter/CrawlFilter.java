package com.excilys.formation.gwt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.background.GAEJavaScriptExecutor;

/**
 * Servlet that makes this application crawlable.<br />
 * 
 * This servlet does not make any HTTP request to get the content, instead it
 * directly streams the HTML file.
 * 
 * Based on :
 * 
 * <ul>
 * <li><a href=
 * "http://code.google.com/p/google-web-toolkit/source/detail?spec=svn6211&r=6211"
 * >GWT Showcase</a>
 * <li><a href=
 * "http://code.google.com/p/bitdual/source/browse/representdemocracy/development/src/com/bitdual/server/CrawlServlet.java?spec=svn233&r=233"
 * >A version of the CrawlServlet for AppEngine</a>
 * <li><a href=
 * "http://www.ozdroid.com/#!BLOG/2010/10/12/How_to_Make_Google_AppEngine_Applications_Ajax_Crawlable"
 * >An interesting article</a>
 * </ul>
 * 
 */
public final class CrawlFilter implements Filter {

    private static final String _ESCAPED_FRAGMENT = "_escaped_fragment_";

    /**
     * Filters all requests and invokes headless browser if necessary.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (filterConfig == null) {
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (isCrawlerRequest(httpRequest)) {
            crawl(httpRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean isCrawlerRequest(HttpServletRequest httpRequest) {
        return httpRequest.getParameterMap().containsKey(_ESCAPED_FRAGMENT);
    }

    private void crawl(HttpServletRequest request, ServletResponse response) throws UnsupportedEncodingException, IOException, MalformedURLException {

        WebClient webClient = createWebClient();

        URL htmlResource = findHtmlResource(request);

        URL htmlResourceWithHashbang = new URL(htmlResource, buildHashbang(request));

        HtmlPage page = webClient.getPage(htmlResourceWithHashbang);

        pumpEventLook(webClient);

        String content = extractContent(page);

        webClient.closeAllWindows();

        String pageName = buildPageName(request);

        sendResponse(response, content, pageName);
    }

    private WebClient createWebClient() {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
        webClient.setJavaScriptEnabled(true);
        return webClient;
    }

    private URL findHtmlResource(HttpServletRequest request) {
        try {
            return filterConfig.getServletContext().getResource(request.getRequestURI());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildHashbang(HttpServletRequest request) {
        String[] escapedFragments = parameterMap(request).get(_ESCAPED_FRAGMENT);
        return "#!" + escapedFragments[0];
    }

    @SuppressWarnings("unchecked")
    private Map<String, String[]> parameterMap(HttpServletRequest request) {
        return request.getParameterMap();
    }

    private void pumpEventLook(WebClient webClient) {
        GAEJavaScriptExecutor gaejs = (GAEJavaScriptExecutor) webClient.getJavaScriptEngine().getJavaScriptExecutor();
        int pumpEventLoop = gaejs.pumpEventLoop(1000);
        int lastTime = -1;
        while (pumpEventLoop > 0 && lastTime != pumpEventLoop) {
            lastTime = pumpEventLoop;
            pumpEventLoop = gaejs.pumpEventLoop(1000);
        }
    }

    private String extractContent(HtmlPage page) {
        HtmlDivision currentDiv = (HtmlDivision) page.getByXPath("//div[contains(@class, 'current')]").get(0);
        String divXml = currentDiv.asXml();
        return divXml;
    }

    private String buildPageName(HttpServletRequest request) throws UnsupportedEncodingException {
        StringBuilder pageNameSb = new StringBuilder("http://");
        pageNameSb.append(request.getServerName());
        if (request.getServerPort() != 0) {
            pageNameSb.append(":");
            pageNameSb.append(request.getServerPort());
        }

        String requestURI = request.getRequestURI();
        pageNameSb.append(requestURI);

        String queryString = rewriteQueryString(parameterMap(request));
        pageNameSb.append(queryString);
        String pageName = pageNameSb.toString();
        return pageName;
    }

    private String rewriteQueryString(Map<String, String[]> parameterMap) throws UnsupportedEncodingException {
        StringBuilder queryStringSb = new StringBuilder("");

        if (parameterMap.size() > 1) {
            queryStringSb.append("?");
        }

        for (Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            if (!key.equals(_ESCAPED_FRAGMENT)) {
                String[] values = entry.getValue();
                for (String value : values) {
                    queryStringSb.append(key.toString() + "=" + value + "&");
                }
            }
        }

        if (queryStringSb.length() > 0) {
            queryStringSb.deleteCharAt(queryStringSb.length() - 1);
        }

        queryStringSb.append("#!");
        queryStringSb.append(URLDecoder.decode(parameterMap.get(_ESCAPED_FRAGMENT)[0], "UTF-8"));

        return queryStringSb.toString();
    }

    private void sendResponse(ServletResponse response, String content, String pageName) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>You are viewing a non-interactive page that is intended for the crawler. You probably want to see this page: <a href=\"" + pageName + "\">" + pageName + "</a></p>");
        out.println("<hr>");
        out.println(content);
        out.close();
    }

    private FilterConfig filterConfig = null;

    /**
     * Initializes the filter configuration.
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroys the filter configuration.
     */
    @Override
    public void destroy() {
        filterConfig = null;
    }

}
