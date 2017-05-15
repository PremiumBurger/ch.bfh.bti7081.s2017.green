package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.BaseEntity;
import ch.bfh.bti7081.s2017.green.util.PmsModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public abstract class EntityBean<T extends BaseEntity> implements Serializable {

    private PmsModelMapper modelMapper;

    private T entity;

    public EntityBean() {
        modelMapper = new PmsModelMapper();
    }

    /**
     * Stores the properties of this Bean to the underlaying entity.
     *
     * @return the updated entity
     */
    public T updateEntiy() {
        modelMapper.map(this, entity);
        return entity;
    }

    /**
     * Resets the properties of this Bean to the underlaying entity
     *
     * @return the entity of type <T>
     */
    public T reset() {
        modelMapper.map(entity, this);
        return entity;
    }

    /**
     * Sets the entity and copies all properties of it to this bean
     *
     * @param entity the entity
     */
    public void setEntity(final T entity) {
        this.entity = entity;
        modelMapper.map(entity, this);
    }

    /**
     * Gets the id of the underlying entity
     *
     * @return the entity id
     */
    public long getId() {
        return entity.getId();
    }
}
