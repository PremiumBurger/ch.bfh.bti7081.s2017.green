package ch.bfh.bti7081.s2017.green;


import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.*;
import ch.bfh.bti7081.s2017.green.domain.builder.HealthVisitorBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Tests the Entity <-> Bean Mappings
 */
public class PmsModelMapperTest {


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void TestEntityBeanSetEntity() {
        // Arrange
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        HealthVisitorBean hvBean = new HealthVisitorBean();

        // Act
        hvBean.setEntity(hv, true);

        // Assert
        Assert.assertEquals(hv.getAhvNr(), hvBean.getAhvNr());
        Assert.assertNotNull(hvBean.getAddress());
        Assert.assertNotNull(hvBean.getAddress().getId());
    }

    @Test
    public void TestPatientEntityBeanSetEntity() {
        // Arrange
        AppointmentJournalEntry journalEntry = new AppointmentJournalEntry();
        journalEntry.setText("Test Journal Entry");
        journalEntry.setImportant(true);
        journalEntry.setJournalEntryType(0);

        Journal journal = new Journal();
        journal.addJournalEntry(journalEntry);

        Patient p = new Patient();
        p.setFirstName("Tobi");
        p.setJournal(journal);

        PatientBean pb = new PatientBean();

        // Act
        pb.setEntity(p, true);

        // Assert
        Assert.assertNotNull(pb.getJournal());
        Assert.assertNotNull(pb.getJournal().getJournalEntries());
    }

    @Test
    public void TestEntityBeanReset() {
        // Arrange
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        HealthVisitorBean hvBean = new HealthVisitorBean();
        hvBean.setEntity(hv, true);
        String newAvhNr = "the new ahv nr";

        // Act
        hvBean.setAhvNr(newAvhNr);
        hvBean.setAddress(null);
        hvBean.reset();

        // Assert
        Assert.assertNotEquals(newAvhNr, hvBean.getAhvNr());
        Assert.assertNotNull(hvBean.getAddress());
        Assert.assertNotNull(hvBean.getAddress().getId());
    }

    @Test
    public void TestEntityBeanUpdate() {
        // Arrange
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        HealthVisitorBean hvBean = new HealthVisitorBean();
        hvBean.setEntity(hv, true);
        String newAvhNr = "the new ahv nr";
        String newAddressCity = "the new addresscity";

        // Act
        hvBean.setAhvNr(newAvhNr);
        hvBean.getAddress().setCity(newAddressCity);
        Person updatedPerson = hvBean.updateEntity();

        // Assert
        Assert.assertEquals(newAvhNr, updatedPerson.getAhvNr());
        Assert.assertEquals(newAddressCity, updatedPerson.getAddress().getCity());
    }

    @Test
    public void TestNewBean() {
        // Arrange
        AppointmentBean appBean = new AppointmentBean();
        appBean.setFrom(LocalDateTime.now());
        appBean.setTo(LocalDateTime.now().plusHours(2));

        // Act
        Appointment appEntity = appBean.updateEntity();

        // Assert
        Assert.assertNotNull(appEntity);
        Assert.assertNotNull(appEntity.getFrom());
        Assert.assertNotNull(appEntity.getTo());
    }

}
