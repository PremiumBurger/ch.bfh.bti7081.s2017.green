package ch.bfh.bti7081.s2017.green.ui.components.address;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import ch.bfh.bti7081.s2017.green.ui.components.search.SearchViewImpl;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Implementation of the AddressView to show a List of Addresses aquired from the database
 * Created by joris on 09.05.17.
 * @author schms27
 */
@Component
public class AddressViewImpl extends MasterPageImpl implements AddressView {
    //Variable Declaration
    private AddressViewListener listener;   //Listener to forward events to AddressViewPresenter
    private Grid<AddressBean> grid;         //Vaadin Grid to show the Addresses

    public AddressViewImpl() {
        HorizontalLayout layout = new HorizontalLayout();

        SearchViewImpl header = new SearchViewImpl(); //Searchbar to set on top of the Page
        header.setTitle("MyDay");

        //Initialize Grid and set the Columnorder
        grid = new Grid<>(AddressBean.class);
        grid.setColumnOrder(grid.getColumn("strasse"), grid.getColumn("plz"), grid.getColumn("city"), grid.getColumn("country"));
        grid.getColumn("id").setHidden(true);

        //Declare & Initialize Vaadin Button for easy Testing of the Address-Loading, can be removed later
        Button btnTest = new Button("Test (load Address)");
        btnTest.setWidth(100, Unit.PIXELS);
        btnTest.addClickListener(b -> listener.onButtonClick());

        //Assemble UI Components
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
