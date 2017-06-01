package ch.bfh.bti7081.s2017.green.ui.components.search;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.*;

/**
 * Component to Display a Searchbar
 * Created by joris on 05.05.17.
 * @author schms27
 */
@org.springframework.stereotype.Component
public class SearchViewImpl extends AbsoluteLayout implements SearchView {
    private SearchViewListener listener;   //Listener to forward events to AddressViewPresenter

    ComboBox<PatientBean> search;

    public SearchViewImpl() {
        final HorizontalLayout layout = new HorizontalLayout();
        search = new Autocomplete<>();
        layout.addComponent(search);
        layout.setWidth(100,Unit.PERCENTAGE);
        addComponent(layout);
    }

    @Override
    public void addListener(SearchViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(Set<PatientBean> patients) {
        search.setCaption("Search your Boardi");
        search.setPlaceholder("start typing to find your Boardi");
        search.setItems(patients);
        search.setPopupWidth("100%");
        search.setWidth("100%");
        search.addValueChangeListener(event -> listener.onClick(event.getValue()));
    }

    @Override
    public void setSelection(PatientBean patientBean) {
        Notification.show("The selected Patient is"+patientBean.getId()+" With name: "+patientBean.getFirstName(),
                Notification.Type.HUMANIZED_MESSAGE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
