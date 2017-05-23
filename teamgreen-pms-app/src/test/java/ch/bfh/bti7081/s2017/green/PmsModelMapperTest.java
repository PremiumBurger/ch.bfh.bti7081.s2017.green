package ch.bfh.bti7081.s2017.green;


import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.domain.Person;
import ch.bfh.bti7081.s2017.green.domain.builder.AddressBuilder;
import ch.bfh.bti7081.s2017.green.domain.builder.HealthVisitorBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
