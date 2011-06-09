package com.excilys.formation.gwt.client.formation.demo;

import com.excilys.formation.gwt.client.slider.Analytics;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class Inscription extends Composite {

    interface Binder extends UiBinder<Widget, Inscription> {}

    private static final Binder binder = GWT.create(Binder.class);

    private final PopupPanel closable;

    public Inscription(PopupPanel closable) {
        this.closable = closable;
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("closeButton")
    void onCloseClick(ClickEvent e) {
        Analytics.trackModuleRelativePageView("registerDialog/noThanks");
        closable.hide();
    }

}
