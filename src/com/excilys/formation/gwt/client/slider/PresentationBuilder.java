package com.excilys.formation.gwt.client.slider;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.excilys.formation.gwt.client.slider.slides.ChapterHolder;
import com.google.gwt.user.client.ui.SimplePanel;

public interface PresentationBuilder {

    void definePreloadedBrushes(List<Brush> brushes);

    void loadChapters(ChapterHolder chapterHolder);

    void initTop(SimplePanel top);

}