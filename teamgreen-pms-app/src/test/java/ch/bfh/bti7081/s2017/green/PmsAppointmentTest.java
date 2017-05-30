package ch.bfh.bti7081.s2017.green;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.AppointmentStateType;
import ch.bfh.bti7081.s2017.green.domain.builder.AppointmentBuilder;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Set;


/**
 * Tests the Appointment
 * @author schms27
 */
//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"/application.properties"})
public class PmsAppointmentTest {

    //Todo:Find out how to mock service
    //@InjectMocks
    /*@Resource
    private Appointment appointment;

    @Resource
    @Mock
    private AppointmentServiceImpl service;*/


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void TestAppointmentEntityBean() {
        // Arrange
        //Set<AppointmentBean> testBeanList = service.getAll();



        Appointment appointment = AppointmentBuilder.anAppointment().rundumSorglos().build();
        AppointmentBean appointmentBean = new AppointmentBean();


        // Act
        appointmentBean.setEntity(appointment, true);

        AppointmentStateType type1 = appointment.getAppointmentStateType();
        AppointmentStateTypeBean type2 = appointmentBean.getAppointmentStateType();

        // Assert
        //Assert.assertEquals(type2.getAppointmentState().getDescription(),"NEW");
    }


}
