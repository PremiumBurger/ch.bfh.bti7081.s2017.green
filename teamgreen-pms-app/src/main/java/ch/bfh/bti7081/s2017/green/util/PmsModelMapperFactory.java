package ch.bfh.bti7081.s2017.green.util;

import ch.bfh.bti7081.s2017.green.bean.*;
import ch.bfh.bti7081.s2017.green.domain.*;
import ch.bfh.bti7081.s2017.green.domain.builder.JournalBuilder;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class PmsModelMapperFactory {

    private static MapperFactory mapperFactory;

    /**
     * Place Mapper Configuration here.
     *
     * @param mapperFactory the mapper factory to config
     */
    private static void initConfiguration(MapperFactory mapperFactory) {
        addClassMap(HealthVisitor.class, HealthVisitorBean.class, mapperFactory);
        addClassMap(Address.class, AddressBean.class, mapperFactory);
        addClassMap(Alarm.class, AlarmBean.class, mapperFactory);
        addClassMap(Appointment.class, AppointmentBean.class, mapperFactory);
        addClassMap(Patient.class, PatientBean.class, mapperFactory);
        addClassMap(Journal.class, JournalBean.class, mapperFactory);
        addClassMap(AppointmentJournalEntry.class, AppointmentJournalEntryBean.class, mapperFactory);
        addClassMap(AppointmentStateType.class, AppointmentStateTypeBean.class, mapperFactory);
    }

    protected static <A extends BaseEntity, B extends EntityBean> void addClassMap(Class<A> a, Class<B> b, MapperFactory mapperFactory) {
        mapperFactory.classMap(a, b).byDefault().customize(new EntityBeanCustomMapper()).register();
    }

    /**
     * Gets an instance of MapperFacade.
     *
     * @return the mapper facade
     */
    public static MapperFacade getMapper() {
        if (mapperFactory == null) {
            mapperFactory = new DefaultMapperFactory.Builder().build();
            initConfiguration(mapperFactory);
        }
        return mapperFactory.getMapperFacade();
    }


}
