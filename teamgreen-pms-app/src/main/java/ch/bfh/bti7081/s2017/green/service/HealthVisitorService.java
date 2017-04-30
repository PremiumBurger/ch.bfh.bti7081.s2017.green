package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;

import java.util.Set;

public interface HealthVisitorService extends BaseServiceInterface<HealthVisitorBean> {

    Set<HealthVisitorBean> find(String lastName);
}
