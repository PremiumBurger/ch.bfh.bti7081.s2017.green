package ch.bfh.bti7081.s2017.green.ui.presenter;

import ch.bfh.bti7081.s2017.green.ui.model.Dashboard;
import ch.bfh.bti7081.s2017.green.ui.view.dashBoard.DashboardView;
import ch.bfh.bti7081.s2017.green.ui.view.dashBoard.DashboardViewListener;
import org.springframework.beans.factory.annotation.Autowired;

public class DashboardPresenter implements DashboardViewListener {

    Dashboard dashboard;

    DashboardView dashboardView;

    @Autowired
    public DashboardPresenter(Dashboard dashboard, DashboardView dashboardView) {
        this.dashboard = dashboard;
        this.dashboardView = dashboardView;

        dashboardView.addListener(this);

    }

    @Override
    public void doSearch() {

    }

    @Override
    public void setAlarm() {

    }

    @Override
    public void showPatientDetails() {

    }

    @Override
    public void showMedication() {

    }
}
