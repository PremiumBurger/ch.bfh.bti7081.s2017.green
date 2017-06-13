package ch.bfh.bti7081.s2017.green.ui.controls;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;


public class H2Title extends Label {

    public H2Title(String title) {
        super(title);
        setSizeUndefined();
        addStyleName(ValoTheme.LABEL_H2);
        addStyleName(ValoTheme.LABEL_NO_MARGIN);

    }

}
