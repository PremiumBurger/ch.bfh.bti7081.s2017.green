package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.EntityBean;

import java.util.Set;

public interface BaseServiceInterface<T extends EntityBean> {

    Set<T> getAll();

    long save(T bean);

    void delete(T bean);

    T getOne(long id);
}
