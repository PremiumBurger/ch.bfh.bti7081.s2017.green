package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.domain.Journal;
import ch.bfh.bti7081.s2017.green.domain.builder.JournalBuilder;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import java.time.LocalDateTime;

public class JournalCRUD extends CustomComponent {

    private FormLayout mainLayout;
    private Button saveAndQuit;
    private Button saveAndNext;
    private BeanValidationBinder<JournalEntryBean> journalEntryBinder;

    public JournalCRUD() {

        this.journalEntryBinder = new BeanValidationBinder<>(JournalEntryBean.class);

        JournalEntryBean bean = new JournalEntryBean();

        journalEntryBinder.setBean(bean);

        mainLayout = new FormLayout();
        mainLayout.setMargin(true);
        mainLayout.addStyleName("outlined");
        mainLayout.setSizeFull();

        TextField text = new TextField("Text", "");
        text.setWidth(100.0f, Unit.PERCENTAGE);
        text.setHeight(10.0f, Unit.PERCENTAGE);
        mainLayout.addComponent(text);

        CheckBox isWichtig = new CheckBox("Wichtig:");

        saveAndNext = new Button("Speichern nächster Eintrag");
        saveAndQuit = new Button("Speichern und schliessen");

        journalEntryBinder.forField(text).bind(JournalEntryBean::getText, JournalEntryBean::setText);
        journalEntryBinder.forField(isWichtig).bind(JournalEntryBean::isImportant, JournalEntryBean::setImportant);
        bean.setCreatedBy(getHealtVisitor());
        bean.setCreatedOn(LocalDateTime.now());
        bean.setJournal(new JournalBean());

        mainLayout.addComponent(text);
        mainLayout.addComponent(isWichtig);
        mainLayout.addComponent(saveAndQuit);
        mainLayout.addComponent(saveAndNext);

    }

    private HealthVisitorBean getHealtVisitor(){
        HealthVisitorBean hb = new HealthVisitorBean();
        hb.setId(1);
        hb.setLastName("Pitex");
        hb.setFirstName("Sabine");

        return hb;
    }
}
