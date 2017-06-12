package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.AppointmentJournalEntryBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.List;

public class JournalEntryListComponent extends CustomComponent {

    private Panel mainPanel;
    private VerticalLayout mainPanelLayout;


    public JournalEntryListComponent(List<JournalEntryBean> journal) {

        this.mainPanel = new Panel();
        mainPanel.setCaption("Journal");

        this.mainPanelLayout = new VerticalLayout();
        mainPanelLayout.setMargin(false);
        mainPanelLayout.setSpacing(false);

        mainPanel.setContent(mainPanelLayout);

        setCompositionRoot(mainPanel);

        addJournalEntriesToLayout(journal);
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
}