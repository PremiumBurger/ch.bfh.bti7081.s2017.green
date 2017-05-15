package ch.bfh.bti7081.s2017.green.util;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.AlarmBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.Alarm;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class PmsModelMapper extends ModelMapper {

    public PmsModelMapper() {
        super();
        initConfiguration();
    }

    private void initConfiguration() {
        getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        createTypeMap(HealthVisitorBean.class, HealthVisitor.class);
        createTypeMap(AddressBean.class, Address.class);
        createTypeMap(AlarmBean.class, Alarm.class);
    }
}
