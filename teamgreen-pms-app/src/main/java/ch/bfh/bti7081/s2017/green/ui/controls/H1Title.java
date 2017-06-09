package ch.bfh.bti7081.s2017.green.ui.controls;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;


public class H1Title extends Label {

    public H1Title(String title) {
        super(title);
        setSizeUndefined();
        addStyleName(ValoTheme.LABEL_H1);


    }

}
