package com.excilys.formation.gwt.client.formation.demo;

import com.excilys.formation.gwt.client.slider.Analytics;
import com.google.gwt.user.client.ui.DialogBox;

public class RegisterDialog {

    public static void show(String page) {

        Analytics.trackModuleRelativePageView("registerDialog");
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

}
