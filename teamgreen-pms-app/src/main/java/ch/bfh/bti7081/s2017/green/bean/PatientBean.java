package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Patient;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocompletable;

import java.util.ArrayList;
import java.util.List;

public class PatientBean extends PersonBean implements Autocompletable {

    private List<HealthVisitorBean> healthVisitors;

    private List<AppointmentBean> appointments;

    private List<AlarmBean> alarms;

    private JournalBean journal;

    public PatientBean() {
        setEntity(new Patient(), false);
        healthVisitors = new ArrayList<>();
        appointments = new ArrayList<>();
        alarms = new ArrayList<>();
    }

    public List<HealthVisitorBean> getHealthVisitors() {
        return healthVisitors;
    }

    public List<AppointmentBean> getAppointments() {
        return appointments;
    }

    public List<AlarmBean> getAlarms() {
        return alarms;
    }

    public String getSearchString() {
        StringBuilder searchString = new StringBuilder();

        searchString.append(getValue(getFirstName()));
        searchString.append(" ");
        searchString.append(getValue(getLastName()));
        searchString.append(" ");
        if (getAddress() != null){
            searchString.append(getValue(getAddress().getStrasse()));
            searchString.append(" ");
            searchString.append(getValue(getAddress().getCity()));
            searchString.append(" ");
            searchString.append(getValue(getAddress().getPlz()));
            searchString.append(" ");
            searchString.append(getValue(getAddress().getCountry()));
            searchString.append(" ");
            searchString.append(getValue(getAhvNr()));
        }

            return searchString.toString();
    }

    private String getValue(String str){
        if (str != null)
            return str;
        else
            return "--";

    }

    public JournalBean getJournal() {
        if(journal != null) {
            return journal;
        }
        return new JournalBean();
    }

    public void setJournal(JournalBean journal) {
        this.journal = journal;
    }
}
