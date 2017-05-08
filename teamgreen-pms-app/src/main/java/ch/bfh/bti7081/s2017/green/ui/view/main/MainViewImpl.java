package ch.bfh.bti7081.s2017.green.ui.view.main;

import ch.bfh.bti7081.s2017.green.ui.presenter.SearchPresenter;
import ch.bfh.bti7081.s2017.green.ui.view.component.search.SearchViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
@SpringUI
@Theme("valo")
public class MainViewImpl extends VerticalLayout implements MainView{
    private List<MainViewListener> listeners;


    public MainViewImpl() {
        this.listeners = new ArrayList<>();
        final VerticalLayout header = new VerticalLayout(new Label("Header"));
        final VerticalLayout content = new VerticalLayout();
        header.addComponent(new SearchViewImpl());


    }


    @Override
    public void addListener(MainViewListener viewListener) {
        listeners.add(viewListener);
    }


}
