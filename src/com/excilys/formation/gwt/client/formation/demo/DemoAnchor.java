package com.excilys.formation.gwt.client.formation.demo;

import com.excilys.formation.gwt.client.slider.Analytics;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;

public class DemoAnchor extends Composite implements ClickHandler, HasText {

    private Anchor anchor;

    private String page = "linkClicked";

    public DemoAnchor() {
        anchor = new Anchor("Default Text");
        anchor.addClickHandler(this);
        initWidget(anchor);
    }

    @Override
    public void onClick(ClickEvent event) {

        Analytics.trackModuleRelativePageView("registerDialog/" + page);

        DialogBox dialogBox = new DialogBox();
        Inscription inscription = new Inscription(dialogBox);
        dialogBox.setWidget(inscription);
        dialogBox.setText("Inscrivez-vous !");
        dialogBox.setAutoHideEnabled(false);
        dialogBox.setAnimationEnabled(true);
        dialogBox.setAutoHideOnHistoryEventsEnabled(true);
        dialogBox.setGlassEnabled(true);

        dialogBox.center();
    }

    @Override
    public String getText() {
        return anchor.getText();
    }

    @Override
    public void setText(String text) {
        anchor.setText(text);
    }

    public void setPage(String page) {
        this.page = page;
    }

}
