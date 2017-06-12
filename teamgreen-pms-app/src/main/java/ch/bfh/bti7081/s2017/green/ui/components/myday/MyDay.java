package ch.bfh.bti7081.s2017.green.ui.components.myday;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * UI Model fo the myDaydataStructure
 */
@Transactional
@Component
public class MyDay {

    /**
     * Declares appointmentService
     */
    private AppointmentService appointmentService;

    /**
     * @param appointmentService Initializes appointmentservice
     */
    public MyDay(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /**
     * @return returns a List of Appointmentbeans as a List
     * AppointmentService delivers Appointmentbeans
     */
    public List<AppointmentBean> getAll(){
        return new ArrayList<AppointmentBean>(appointmentService.getAll());
    }
}
