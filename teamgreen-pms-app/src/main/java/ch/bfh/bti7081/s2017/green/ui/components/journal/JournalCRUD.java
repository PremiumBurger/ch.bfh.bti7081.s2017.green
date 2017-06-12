package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.domain.Journal;
import ch.bfh.bti7081.s2017.green.domain.builder.JournalBuilder;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.navigator.View;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;

import java.time.LocalDateTime;

public class JournalCRUD extends Window {

    private FormLayout mainLayout;
    private Button saveAndQuit;
    private Button saveAndNext;
    private Button cancel;
    private BeanValidationBinder<JournalEntryBean> journalEntryBinder;
    private JournalEntryBean bean;

    public  JournalCRUD(JournalEntryBean bean) {

        this.bean = bean;
        this.journalEntryBinder = new BeanValidationBinder<>(JournalEntryBean.class);
        journalEntryBinder.setBean(bean);

        this.setCaption("Journal Eintrag hinzufügen");

        mainLayout = new FormLayout();
        mainLayout.setMargin(true);
        mainLayout.setSizeFull();

        TextField text = new TextField("Text", "");
        text.setWidth(100.0f, Unit.PERCENTAGE);
        text.setHeight(30.0f, Unit.PERCENTAGE);
        mainLayout.addComponent(text);

        CheckBox isWichtig = new CheckBox("Wichtig:");

        saveAndNext = new Button("Speichern nächster Eintrag");
        saveAndQuit = new Button("Speichern und schliessen");
        cancel = new Button("Abbrechen");

        journalEntryBinder.forField(text).bind(JournalEntryBean::getText, JournalEntryBean::setText);
        journalEntryBinder.forField(isWichtig).bind(JournalEntryBean::isImportant, JournalEntryBean::setImportant);

        mainLayout.addComponent(text);
        mainLayout.addComponent(isWichtig);
        mainLayout.addComponent(saveAndQuit);
        //mainLayout.addComponent(saveAndNext);
        mainLayout.addComponent(cancel);

        saveAndQuit.addClickListener(e -> {
            this.fireEvent(new Event(this));
            this.close();
        });

        cancel.addClickListener(e -> {
            this.close();
            //wieso wird onSaveJournalEntryButtonClick ausgeführt?
        });

//        saveAndNext.addClickListener(e -> {
//            this.fireEvent(new Event(this));
//            //
//          });

        this.setContent(mainLayout);
    }

    public Registration addSaveJournalEntryListener(JournalEntrySaveButtonClickEvent event){
        return this.addListener(Event.class, event, JournalEntrySaveButtonClickEvent.BUTTON_CLICK_METHOD);
    }

//    public Registration addSaveJournalEntryAndNextListener(JournalEntrySaveAndNextButtonClickEvent event){
//        return this.addListener(Event.class, event, JournalEntrySaveButtonClickEvent.BUTTON_CLICK_METHOD);
//    }

    public JournalEntryBean getBean() {
        return bean;
    }
}
