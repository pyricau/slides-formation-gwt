package com.excilys.formation.gwt.client.formation.demo;

import com.excilys.formation.gwt.client.formation.introduction.Introduction.AQuoi;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Compilation;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Concurrents;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Fonctionnement;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Historique;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Limitations;
import com.excilys.formation.gwt.client.formation.introduction.Introduction.Titre;
import com.excilys.formation.gwt.client.formation.introduction.TropSimple;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Introduction extends Chapter {

    @UiTemplate("Plan.ui.xml")
    public interface Plan extends UiBinder<Widget, WidgetSlide> {
        Plan binder = GWT.create(Plan.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(AQuoi.binder);
        addNotesSlide(Historique.binder);
        addNotesSlide(Fonctionnement.binder);
        addNotesSlide(Compilation.binder);
        addPresentable(new TropSimple());
        addNotesSlide(Limitations.binder);
        addNotesSlide(Concurrents.binder);
        addWidgetSlide(Plan.binder);
    }

}
