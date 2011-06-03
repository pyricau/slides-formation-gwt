package com.excilys.formation.gwt.client.formation;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;
import com.excilys.formation.gwt.client.formation.demo.Demo;
import com.excilys.formation.gwt.client.slider.PresentationEntryPoint;
import com.excilys.formation.gwt.client.slider.slides.ChapterHolder;

public class DemoPresentation extends PresentationEntryPoint {

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Demo());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.JAVA());
    }

}
