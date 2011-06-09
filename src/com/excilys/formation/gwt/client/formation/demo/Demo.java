package com.excilys.formation.gwt.client.formation.demo;

import com.excilys.formation.gwt.client.formation.introduction.Introduction.AQuoi;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Compilation;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Concurrents;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Fonctionnement;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Historique;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Limitations;
import com.excilys.formation.gwt.client.formation.widgets.Widgets;
import com.excilys.formation.gwt.client.slider.shownotes.ElementSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Demo extends Chapter {

    @UiTemplate("Plan.ui.xml")
    public interface Plan extends UiBinder<Widget, WidgetSlide> {
        Plan binder = GWT.create(Plan.class);
    }

    @UiTemplate("Titre.ui.xml")
    public interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(AQuoi.binder);
        addNotesSlide(Historique.binder);
        addWidgetNotesSlide(Fonctionnement.binder);
        addWidgetNotesSlide(Compilation.binder);
        addPresentable(new TropSimple());
        addVisibleSlide(Widgets.Showcase.binder);
        addNotesSlide(Limitations.binder);
        addNotesSlide(Concurrents.binder);
        addWidgetSlide(Plan.binder);
    }

}
