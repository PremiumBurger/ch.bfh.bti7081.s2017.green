package ch.bfh.bti7081.s2017.green.ui.presenter;

import ch.bfh.bti7081.s2017.green.ui.model.Main;
import ch.bfh.bti7081.s2017.green.ui.view.main.MainView;
import ch.bfh.bti7081.s2017.green.ui.view.main.MainViewListener;

/**
 * Created by joris on 08.05.17.
 */
public class MainViewPresenter implements MainViewListener {
    private MainView mainView;
    private Main main;

    public MainViewPresenter(MainView mainView, Main main) {
        this.mainView = mainView;
        this.main = main;
        mainView.addListener(this);
    }
}
