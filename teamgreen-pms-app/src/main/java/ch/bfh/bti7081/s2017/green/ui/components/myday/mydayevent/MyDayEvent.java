package ch.bfh.bti7081.s2017.green.ui.components.myday.mydayevent;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joris on 16.05.17.
 */
@Component
@Transactional
public class MyDayEvent {
    private AppointmentService service;

    @Autowired
    public MyDayEvent(AppointmentService service) {
        this.service = service;
    }

    public AppointmentBean getSelectedEvents(){
        return service.getAll().stream().findFirst().get();
    }

}
