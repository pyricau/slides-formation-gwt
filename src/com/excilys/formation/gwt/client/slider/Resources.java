package com.excilys.formation.gwt.client.slider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

    public static final Resources instance = GWT.create(Resources.class);

    @NotStrict
    CssResource main();

    @NotStrict
    CssResource shownotes();

    @Source("com/excilys/formation/gwt/assets/slide-bg.png")
    ImageResource slideBg();

    @Source("com/excilys/formation/gwt/assets/title-puce-top.png")
    ImageResource learningIcon();

    @Source("com/excilys/formation/gwt/assets/logo-ebi-top.png")
    ImageResource ebiIcon();

    @Source("com/excilys/formation/gwt/assets/logo-exc-grp-bottom.png")
    ImageResource excilysIcon();

    @Source("com/excilys/formation/gwt/assets/plan-bg.png")
    ImageResource planBg();
}
