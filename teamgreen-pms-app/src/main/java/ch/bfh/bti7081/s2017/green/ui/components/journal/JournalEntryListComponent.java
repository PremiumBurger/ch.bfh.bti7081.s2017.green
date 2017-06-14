package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.AppointmentJournalEntryBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.List;

/**
 * A CustomComponent to Display the journal entries in a Panel.
 */
public class JournalEntryListComponent extends CustomComponent {

    private Panel mainPanel;
    private VerticalLayout mainPanelLayout;
    private Button addJournalEntryButton;

    public JournalEntryListComponent(List<JournalEntryBean> journal) {

        // Set up the Mainpaneel
        mainPanel = new Panel();
        mainPanel.setCaption("Journal");

        addJournalEntryButton = new Button("New Entry");
        addJournalEntryButton.setIcon(VaadinIcons.PLUS_CIRCLE);

        // Listener for the add Entry Button
        addJournalEntryButton.addClickListener(e -> this.fireEvent(new Event(this)) );

        // Set up the content layout
        mainPanelLayout = new VerticalLayout();
        mainPanelLayout.setMargin(false);
        mainPanelLayout.setSpacing(false);
        mainPanelLayout.addComponent(addJournalEntryButton);

        mainPanel.setContent(mainPanelLayout);

        setCompositionRoot(mainPanel);

        if(journal.size()>0){
            addJournalEntriesToLayout(journal);
        }
        else{
            mainPanelLayout.addComponent(new Label("Keine Einträge vorhanden"));
        }
    }

    private void addJournalEntriesToLayout(List<JournalEntryBean> entries){
        for (JournalEntryBean entry : entries) {
            //Todo: Add different Types

            Panel entryPanel = new Panel();
            HorizontalLayout entryPanelLayout = new HorizontalLayout();

            entryPanelLayout.setWidth("100%");
            entryPanelLayout.setMargin(new MarginInfo(false, true, false, true));
            ;

            Label contentText = new Label(entry.getCreatedOnFormatedString() + " " + entry.getCreatedBy().getFirstName() + " " + entry.getCreatedBy().getLastName());
            contentText.setWidth("100%");
            contentText.setHeight("100%");

            if (entry.isImportant()) {
                Label icon = new Label("");
                icon.setStyleName("important");
                icon.setIcon(VaadinIcons.EXCLAMATION_CIRCLE);
                entryPanelLayout.addComponent(icon);
            }

            entryPanelLayout.addComponent(contentText);
            entryPanelLayout.setExpandRatio(contentText, 1.0f);

            entryPanel.setContent(entryPanelLayout);
            entryPanel.setCaption(entry.getText());

            if (entry instanceof AppointmentJournalEntryBean) {
                entryPanel.setIcon(VaadinIcons.CALENDAR);
            }

            mainPanelLayout.addComponent(entryPanel);
        }
    }

    /**
     * @param event The event to be called on add-button click
     * @return
     */
    public Registration addNewJournalListener(JournalButtonClickEvent event){
        return this.addListener(Event.class, event, JournalButtonClickEvent.BUTTON_CLICK_METHOD);
    }
}