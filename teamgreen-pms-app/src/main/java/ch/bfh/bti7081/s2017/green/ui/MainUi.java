package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.demo.healthvisitor.HealthVisitorEdit;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class MainUi extends UI {

    final TextField filter;
    private final Button addNewBtn;
    @Autowired
    HealthVisitorService healthVisitorService;
    @Autowired
    HealthVisitorEdit healthVisitorEdit;
    Grid<HealthVisitorBean> healthVisitorGrid;

    public MainUi() {
        healthVisitorGrid = new Grid<>(HealthVisitorBean.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New Health Visitor", VaadinIcons.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, healthVisitorGrid, healthVisitorEdit);
        setContent(mainLayout);

        healthVisitorGrid.setHeight(300, Unit.PIXELS);
        healthVisitorGrid.setColumns("id", "firstName", "lastName");

        filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> listHealthVisitors(e.getValue()));

        // Connect selected health visitor to editor or hide if none is selected
        healthVisitorGrid.asSingleSelect().addValueChangeListener(e -> {
            healthVisitorEdit.editHealthVisitor(e.getValue());
        });

        // Instantiate and edit new HealthVisitor the new button is clicked
        addNewBtn.addClickListener(e -> healthVisitorEdit.editHealthVisitor(new HealthVisitorBean()));

        // Listen changes made by the editor, refresh data from backend
        healthVisitorEdit.setChangeHandler(() -> {
            healthVisitorEdit.setVisible(false);
            listHealthVisitors(filter.getValue());
        });

        // Initialize listing
        listHealthVisitors(null);
    }

    void listHealthVisitors(String lastNameFilter) {
        if (StringUtils.isEmpty(lastNameFilter)) {
            healthVisitorGrid.setItems(healthVisitorService.getAll());
        } else {
            healthVisitorGrid.setItems(healthVisitorService.find(lastNameFilter));
        }
    }

}
