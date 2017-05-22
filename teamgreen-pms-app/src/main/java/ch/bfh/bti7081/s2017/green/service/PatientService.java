package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;

import java.util.Set;

public interface PatientService extends BaseServiceInterface<PatientBean> {

    Set<PatientBean> find(String str);

}
