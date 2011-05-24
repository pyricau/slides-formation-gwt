package com.excilys.formation.gwt.client.formation;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;
import com.excilys.formation.gwt.client.formation.demo.Introduction;
import com.excilys.formation.gwt.client.slider.PresentationEntryPoint;
import com.excilys.formation.gwt.client.slider.slides.ChapterHolder;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Demo extends PresentationEntryPoint {

    @UiTemplate("Plan.ui.xml")
    public interface Plan extends UiBinder<Element, ElementSlide> {
        Plan binder = GWT.create(Plan.class);
    }

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Introduction());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.JAVA());
    }

}
