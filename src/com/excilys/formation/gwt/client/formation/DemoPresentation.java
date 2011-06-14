package com.excilys.formation.gwt.client.formation;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;
import com.excilys.formation.gwt.client.formation.demo.Demo;
import com.excilys.formation.gwt.client.formation.demo.RegisterDialog;
import com.excilys.formation.gwt.client.slider.PresentationEntryPoint;
import com.excilys.formation.gwt.client.slider.slides.ChapterHolder;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class DemoPresentation extends PresentationEntryPoint {

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Demo());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.JAVA());
    }

    @Override
    public void initTop(SimplePanel top) {

        Button registerButton = new Button("Inscrivez-vous !");

        registerButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RegisterDialog.show("button");
            }
        });

        registerButton.addStyleName("registerButton");

        HorizontalPanel panel = new HorizontalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setWidth("100%");
        panel.add(registerButton);

        top.setWidget(panel);
    }
}
