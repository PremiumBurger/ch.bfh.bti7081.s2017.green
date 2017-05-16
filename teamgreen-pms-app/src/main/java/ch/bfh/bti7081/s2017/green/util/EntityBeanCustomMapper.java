package ch.bfh.bti7081.s2017.green.util;

import ch.bfh.bti7081.s2017.green.bean.EntityBean;
import ch.bfh.bti7081.s2017.green.domain.BaseEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Custom Entity Bean mapper which sets and reset the entities
 *
 * @param <S> the Base Entity
 * @param <D> the Entity Bean
 */
public class EntityBeanCustomMapper<S extends BaseEntity, D extends EntityBean> extends CustomMapper<S, D> {

    @Override
    public void mapAtoB(S a, D b, MappingContext context) {
        DefaultMapperFactory defaultMapper = new DefaultMapperFactory.Builder().build();
        defaultMapper.classMap(a.getClass(), b.getClass()).byDefault();
        defaultMapper.getMapperFacade().map(a, b);
        b.setEntity(a, false);
    }

    @Override
    public void mapBtoA(D b, S a, MappingContext context) {
        DefaultMapperFactory defaultMapper = new DefaultMapperFactory.Builder().build();
        defaultMapper.classMap(b.getClass(), a.getClass()).byDefault();
        defaultMapper.getMapperFacade().map(b, a);
    }

}
