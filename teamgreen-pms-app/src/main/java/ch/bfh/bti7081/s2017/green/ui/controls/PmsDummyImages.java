package ch.bfh.bti7081.s2017.green.ui.controls;

import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;

public abstract class PmsDummyImages {

    public static Image getHealthVisitorImage() {
        return getImageResource("img/healthvisitor.jpg");
    }

    public static Image getPatientImage() {
        return getImageResource("img/patient.jpg");
    }

    private static Image getImageResource(String resourceId) {
        ThemeResource profileImg = new ThemeResource(resourceId);
        Image image = new Image(null, profileImg);
        image.setWidth(150, Sizeable.Unit.PIXELS);
        return image;
    }
}
