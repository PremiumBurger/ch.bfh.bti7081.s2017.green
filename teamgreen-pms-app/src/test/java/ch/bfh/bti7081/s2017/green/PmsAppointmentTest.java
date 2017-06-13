package ch.bfh.bti7081.s2017.green;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.data.AppointmentRepository;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.builder.AppointmentBuilder;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import ch.bfh.bti7081.s2017.green.webservice.GoogleGeocodingWebService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;


/**
 * Tests the Appointment
 * @author schms27
 */
@RunWith(MockitoJUnitRunner.class)
public class PmsAppointmentTest {

    @Mock
    private AppointmentRepository repository;

    @Mock
    private GoogleGeocodingWebService googleGeocodingWebService;

    private AppointmentServiceImpl service;

    Set<Appointment> allAppointments = new HashSet<Appointment>();
    Appointment appointmentDomainModel;

    @Before
    public void setUp() throws Exception {
        appointmentDomainModel = AppointmentBuilder.anAppointment().rundumSorglos().build();

        //Set Attributes which normally get set by db
        appointmentDomainModel.setId(1);
        appointmentDomainModel.getAppointmentStateType().setDescription("New");

        allAppointments.add(appointmentDomainModel);
        service = new AppointmentServiceImpl(repository, googleGeocodingWebService);

        //Mock repos functionality
        Mockito.when(repository.findAll()).thenReturn(() -> allAppointments.iterator());
        Mockito.when(repository.findOne((long)1)).thenReturn(appointmentDomainModel);
        Mockito.when(repository.save(appointmentDomainModel)).thenReturn(appointmentDomainModel);
    }

    @Test
    public void TestAppointmentService() {
        // Arrange
        Set<AppointmentBean> allAppointmentBeans = service.getAll();
        AppointmentBean bean = service.getOne(1);


        // Assert
        Assert.assertTrue(service.getOne(1)!=null);
        Assert.assertEquals(service.getOne(1).getId(),bean.getId());
        Assert.assertEquals(allAppointments.size(),allAppointmentBeans.size());
        Assert.assertTrue(bean.getHealthVisitor().getLastName().equals(appointmentDomainModel.getHealthVisitor().getLastName()));
        Assert.assertTrue(bean.getAppointmentStateType().getDescription().equals(appointmentDomainModel.getAppointmentStateType().getDescription()));
        Assert.assertTrue(bean.getFrom().equals(appointmentDomainModel.getFrom()));
        Assert.assertEquals(service.save(bean),(long)1);
    }
}
