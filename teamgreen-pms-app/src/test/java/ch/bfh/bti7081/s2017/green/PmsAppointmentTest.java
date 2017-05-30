package ch.bfh.bti7081.s2017.green;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.AppointmentStateType;
import ch.bfh.bti7081.s2017.green.domain.builder.AppointmentBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Appointment
 * @author schms27
 */
public class PmsAppointmentTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void TestAppointmentEntityBean() {
        // Arrange
        Appointment appointment = AppointmentBuilder.anAppointment().rundumSorglos().build();
        AppointmentBean appointmentBean = new AppointmentBean();


        // Act
        appointmentBean.setEntity(appointment, true);

        AppointmentStateType type1 = appointment.getAppointmentStateType();
        AppointmentStateTypeBean type2 = appointmentBean.getAppointmentStateType();

        // Assert
        Assert.assertEquals(type2.getAppointmentState().toString(),"Appointment Idle State");
    }


}
