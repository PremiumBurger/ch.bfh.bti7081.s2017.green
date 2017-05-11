package ch.bfh.bti7081.s2017.green.ui;

public class MasterPagePresenter implements MasterPageListener {
    private MasterPage mainView;
    private MasterPage main;

    public MasterPagePresenter(MasterPage mainView, MasterPage main) {
        this.mainView = mainView;
        this.main = main;
    }
}
