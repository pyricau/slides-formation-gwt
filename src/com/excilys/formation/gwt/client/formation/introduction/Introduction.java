package com.excilys.formation.gwt.client.formation.introduction;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.shownotes.ElementSlideNotes;
import com.excilys.formation.gwt.client.slider.shownotes.WidgetSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Introduction extends Chapter {

    @UiTemplate("Titre.ui.xml")
    public interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("AQuoi.ui.xml")
    public interface AQuoi extends UiBinder<Element, ElementSlideNotes> {
        AQuoi binder = GWT.create(AQuoi.class);
    }

    @UiTemplate("Historique.ui.xml")
    public interface Historique extends UiBinder<Element, ElementSlideNotes> {
        Historique binder = GWT.create(Historique.class);
    }

    @UiTemplate("Fonctionnement.ui.xml")
    public interface Fonctionnement extends UiBinder<Widget, WidgetSlideNotes> {
        Fonctionnement binder = GWT.create(Fonctionnement.class);
    }

    @UiTemplate("Compilation.ui.xml")
    public interface Compilation extends UiBinder<Widget, WidgetSlideNotes> {
        Compilation binder = GWT.create(Compilation.class);
    }

    @UiTemplate("Limitations.ui.xml")
    public interface Limitations extends UiBinder<Element, ElementSlideNotes> {
        Limitations binder = GWT.create(Limitations.class);
    }

    @UiTemplate("Concurrents.ui.xml")
    public interface Concurrents extends UiBinder<Element, ElementSlideNotes> {
        Concurrents binder = GWT.create(Concurrents.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(AQuoi.binder);
        addNotesSlide(Historique.binder);
        addWidgetNotesSlide(Fonctionnement.binder);
        addWidgetNotesSlide(Compilation.binder);
        addPresentable(new TropSimple());
        addNotesSlide(Limitations.binder);
        addNotesSlide(Concurrents.binder);
        addSlide(Plan.binder);
    }

}
