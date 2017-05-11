package ch.bfh.bti7081.s2017.green.ui.components.address;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import ch.bfh.bti7081.s2017.green.ui.components.search.SearchViewImpl;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;

import java.util.Set;

/**
 * Created by joris on 09.05.17.
 */
public class AddressViewImpl extends MasterPageImpl implements AddressView {
    private AddressViewListener listener;
    private Grid<AddressBean> grid;
    private SearchViewImpl header;
    private Button btnTest;

    public AddressViewImpl() {
        HorizontalLayout layout = new HorizontalLayout();

        header = new SearchViewImpl();
        header.setTitle("MyDay");

        grid = new Grid<>(AddressBean.class);
        grid.setColumnOrder(grid.getColumn("strasse"), grid.getColumn("plz"), grid.getColumn("city"), grid.getColumn("country"));
        grid.getColumn("id").setHidden(true);

        btnTest = new Button("Test (load Address)");
        btnTest.setWidth(100, Unit.PIXELS);
        btnTest.addClickListener(b -> listener.onButtonClick());

        layout.addComponents(grid, btnTest);
        layout.setSizeFull();
        setHeader(header);
        setViewContent(layout);
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
