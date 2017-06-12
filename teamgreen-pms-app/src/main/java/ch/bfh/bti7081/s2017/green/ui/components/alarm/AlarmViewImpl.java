package ch.bfh.bti7081.s2017.green.ui.components.alarm;

import ch.bfh.bti7081.s2017.green.ui.controls.LinkButton;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 15.05.17.
 */
@Component
public class AlarmViewImpl extends VerticalLayout implements AlarmView{
    AlarmViewListener listener;

    public AlarmViewImpl() {
        LinkButton alarmLink = new LinkButton("Alarm",new ExternalResource("tel:0774099434"));
        addComponents(alarmLink);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    @Override
    public void addListener(AlarmViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init() {

    }
}
