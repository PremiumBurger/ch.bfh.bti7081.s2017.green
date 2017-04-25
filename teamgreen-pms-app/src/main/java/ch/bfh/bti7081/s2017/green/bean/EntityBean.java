package ch.bfh.bti7081.s2017.green.bean;

import org.springframework.beans.BeanUtils;

public abstract class EntityBean<T> {

    private T entity;

    /**
     * Stores the properties of this Bean to the underlaying entity.
     *
     * @return the updated entity
     */
    public T updateEntiy() {
        BeanUtils.copyProperties(this, entity);
        return entity;
    }

    /**
     * Resets the properties of this Bean to the underlaying entity
     *
     * @return the entity of type <T>
     */
    public T reset() {
        BeanUtils.copyProperties(entity, this);
        return entity;
    }

    /**
     * Sets the entity and copies all properties of it to this bean
     *
     * @param entity the entity
     */
    public void setEntity(final T entity) {
        this.entity = entity;
        BeanUtils.copyProperties(entity, this);
    }
}
