package ch.bfh.bti7081.s2017.green.ui.components.address;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.ui.*;

import java.util.Set;

/**
 * Created by joris on 09.05.17.
 */
public class AddressViewImpl extends MasterPageImpl implements AddressView {
    private AddressViewListener listener;
    private Grid<AddressBean> grid;
    private Button btnTest;

    public AddressViewImpl() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setResponsive(true);

        grid = new Grid<>(AddressBean.class);

        grid.setColumnOrder(grid.getColumn("strasse"),grid.getColumn("plz"),grid.getColumn("city"),grid.getColumn("country"));
        grid.getColumn("id").setHidden(true);

        btnTest = new Button("Test (load Address)");
        btnTest.addClickListener(b->listener.onButtonClick());


        layout.addComponents(grid, btnTest);
        layout.setSizeFull();
        setViewContent(layout);

        VerticalLayout header = new VerticalLayout();
        header.addComponent(new Label("Pissssseeerrr"));
        setHeader(header);
    }

    @Override
    public void addListener(AddressViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void doSomething(Set<AddressBean> addressBeanSet) {
        grid.setItems(addressBeanSet);
    }
}
