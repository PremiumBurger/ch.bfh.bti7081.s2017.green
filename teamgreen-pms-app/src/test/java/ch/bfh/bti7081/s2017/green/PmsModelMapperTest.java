package ch.bfh.bti7081.s2017.green;


import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.Alarm;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.domain.builder.AlarmBuilder;
import ch.bfh.bti7081.s2017.green.domain.builder.HealthVisitorBuilder;
import ch.bfh.bti7081.s2017.green.util.PmsModelMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class PmsModelMapperTest {

    private PmsModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        modelMapper = new PmsModelMapper();
    }

    @Test
    public void TestMappingSingleEntity() {
        // Arrange
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        HealthVisitorBean hvBean = new HealthVisitorBean();

        // Act
        modelMapper.map(hv, hvBean);

        // Assert
        Assert.assertNotNull(hvBean.getAhvNr());
        Assert.assertNotNull(hvBean.getAddressBean());
    }

    @Ignore
    public void TestMappingGenericList() {
        // Arrange
        Alarm alarm1 = AlarmBuilder.anAlarm().rundumSorglos().build();
        Alarm alarm2 = AlarmBuilder.anAlarm().rundumSorglos().build();
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        hv.addAlarm(alarm1);
        hv.addAlarm(alarm2);

        HealthVisitorBean hvBean = new HealthVisitorBean();

        // Act
        modelMapper.map(hvBean, hv);

        // Assert
        Assert.assertEquals(2, hvBean.getAlarms().size());
    }

    @Ignore
    public void TestEntityBeanMappings() {
        // Arrange
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        HealthVisitorBean hvBean = new HealthVisitorBean();

        // Act
        hvBean.setEntity(hv);

        // Assert
        Assert.assertEquals(hv.getAhvNr(), hvBean.getAhvNr());
    }


}
