package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;

/**
 * Creates a Window to add (and edit) journal entries
 */
public class JournalCRUD extends Window {

    private FormLayout mainLayout;
    private Button saveAndQuit;
    private Button cancel;
    private BeanValidationBinder<JournalEntryBean> journalEntryBinder;
    private JournalEntryBean bean;

    public  JournalCRUD(JournalEntryBean bean) {

        // Set Workbean
        this.bean = bean;
        this.journalEntryBinder = new BeanValidationBinder<>(JournalEntryBean.class);
        journalEntryBinder.setBean(bean);

        // Set the Layout
        this.setCaption("Journal Eintrag hinzufügen");
        mainLayout = new FormLayout();
        mainLayout.setMargin(true);
        mainLayout.setSizeFull();

        // UI-Elements
        TextField text = new TextField("Text", "");
        text.setWidth(100.0f, Unit.PERCENTAGE);
        text.setHeight(30.0f, Unit.PERCENTAGE);
        mainLayout.addComponent(text);

        CheckBox isWichtig = new CheckBox("Wichtig:");

        // Binding
        journalEntryBinder.forField(text).bind(JournalEntryBean::getText, JournalEntryBean::setText);
        journalEntryBinder.forField(isWichtig).bind(JournalEntryBean::isImportant, JournalEntryBean::setImportant);

        // Set Buttons
        saveAndQuit = new Button("Speichern und schliessen");
        cancel = new Button("Abbrechen");

        // Listeners for Buttons
        saveAndQuit.addClickListener(e -> {
            this.fireEvent(new JournalEntrySaveEvent(this, this.bean));
            this.close();
        });

        cancel.addClickListener(e -> this.close() ); //wieso wird onSaveJournalEntryButtonClick ausgeführt?

        // Set Components to Layout
        mainLayout.addComponent(text);
        mainLayout.addComponent(isWichtig);
        mainLayout.addComponent(saveAndQuit);
        mainLayout.addComponent(cancel);

        //Set window Layout
        this.setContent(mainLayout);
    }

    /**
     * @param -Event to be triggered on save Button click
     * @return
     */
    public Registration addSaveJournalEntryListener(JournalEntrySaveButtonClickEvent event){
        return this.addListener(JournalEntrySaveEvent.class, event, JournalEntrySaveButtonClickEvent.BUTTON_CLICK_METHOD);
    }
}