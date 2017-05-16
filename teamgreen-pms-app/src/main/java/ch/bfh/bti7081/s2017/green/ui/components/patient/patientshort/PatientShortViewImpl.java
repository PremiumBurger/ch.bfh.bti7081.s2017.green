package ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by joris on 15.05.17.
 */
@Component
public class PatientShortViewImpl extends VerticalLayout implements PatientShortView {



    PatientBean patientModel;
    private TextField test;
    private Label name;
    private Label street;
    private Label cityPlz;


    public PatientShortViewImpl() {

        name = new Label("");
        name.setIcon(VaadinIcons.USER);
        street = new Label("Melchtalstrasse");
        street.setIcon(VaadinIcons.HOME);
        cityPlz = new Label("3014 Bern");
        test = new TextField();
        addComponents(name,street,cityPlz,test);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    @Override
    public void addListener(PatientShortListener listener) {

    }


    @Override
    public void init(PatientBean patient) {
        patientModel = patient;

    }


}
