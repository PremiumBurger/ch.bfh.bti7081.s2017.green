package ch.bfh.bti7081.s2017.green.ui.components.journal;

import com.vaadin.ui.*;

import java.time.LocalDateTime;

public class JournalEntryComponent extends CustomComponent {

    public JournalEntryComponent(LocalDateTime date, String title, boolean important, String typ){
        Panel panel = new Panel(typ);
        VerticalLayout panelContent = new VerticalLayout();
        panel.setContent(panelContent);

        Grid grid = new Grid();
        grid.addColumn(date.toString());
        grid.addColumn(title);
        grid.addColumn(String.valueOf(important));

        panelContent.addComponent(grid);

        setCompositionRoot(panel);
        panel.setSizeFull();
        panelContent.setSizeFull();
    }
}
