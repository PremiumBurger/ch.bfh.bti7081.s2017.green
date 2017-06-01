package ch.bfh.bti7081.s2017.green.util.Visitor;

import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.AppointmentView;

public class JournalVisitor implements Visitor {

    @Override
    public JournalEntryBean visit(AppointmentView appointmentView) {
        return null;
    }
}
