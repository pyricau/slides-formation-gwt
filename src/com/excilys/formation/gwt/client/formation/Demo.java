package com.excilys.formation.gwt.client.formation;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;
import com.excilys.formation.gwt.client.formation.demo.Introduction;
import com.excilys.formation.gwt.client.slider.PresentationEntryPoint;
import com.excilys.formation.gwt.client.slider.slides.ChapterHolder;

public class Demo extends PresentationEntryPoint {

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Introduction());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.JAVA());
    }

}
