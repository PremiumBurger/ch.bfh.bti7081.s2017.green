package ch.bfh.bti7081.s2017.green.util.Visitor;

import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.AppointmentView;

public interface Visitor {

    public JournalEntryBean visit (AppointmentView appointmentView);
    //public FreeJournalEntryBean visit (PatientView patientView);
    //public MedicationJournalEntryBean visit (MedicationView medicationView);

}
