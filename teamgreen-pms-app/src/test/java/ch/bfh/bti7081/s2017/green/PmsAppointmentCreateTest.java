package ch.bfh.bti7081.s2017.green;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import ch.bfh.bti7081.s2017.green.service.AppointmentStateTypeServiceImpl;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorServiceImpl;
import ch.bfh.bti7081.s2017.green.service.PatientServiceImpl;
import ch.bfh.bti7081.s2017.green.ui.DashboardUI;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate.AppointmentCreateModel;
import com.vaadin.server.Page;
import com.vaadin.ui.UI;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 * Tests the Creation & Validation of new Appointments
 * @author schms27
 */
@RunWith(MockitoJUnitRunner.class)
public class PmsAppointmentCreateTest {

    @Mock
    private DashboardUI ui;

    @Mock
    private Page page;

    @Mock
    private AppointmentServiceImpl appointmentService;

    @Mock
    private AppointmentStateTypeServiceImpl appointmentStateTypeService;

    @Mock
    private PatientServiceImpl patientService;

    @Mock
    private HealthVisitorServiceImpl hvService;

    private AppointmentBean appointmentBean;
    private  AppointmentCreateModel mvpmodel;

    private void mockPage() throws NoSuchFieldException, IllegalAccessException {
        Field pageField = UI.class.getDeclaredField("page");
        pageField.setAccessible(true);
        pageField.set(ui, page);
        UI.setCurrent(ui);
        PowerMockito.mockStatic(Page.class);
        Mockito.when(Page.getCurrent()).thenReturn(Mockito.mock(Page.class));
    }

    @Before
    public void setUp() throws Exception {
        mockPage();
        appointmentBean = new AppointmentBean();
        mvpmodel = new AppointmentCreateModel(appointmentService,patientService,appointmentStateTypeService,hvService);

        //Init Bean Correctly
        HealthVisitorBean healthVisitor = new HealthVisitorBean();
        healthVisitor.setId(1);
        appointmentBean.setHealthVisitor(healthVisitor);
        PatientBean patient = new PatientBean();
        patient.setId(5);
        appointmentBean.setPatient(patient);
        appointmentBean.setFrom(LocalDateTime.now());
        appointmentBean.setTo(LocalDateTime.now().plusHours(2));
        appointmentBean.setAppointmentStateType(new AppointmentStateTypeBean());

    }

    /**
     * Trying to save a Correct Appointment
     * Test passes if Save is successful
     */
    @Test
    public void TestAppointmentCreateSaveAllCorrect() {
        //Assert
        Assert.assertTrue(mvpmodel.saveAppointment(appointmentBean)>=0);
    }
}
