package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;

public interface AppointmentService extends BaseServiceInterface<AppointmentBean> {

    /**
     * Get the service of the State Type
     * @return stateTypeService
     */
    public AppointmentStateTypeService getStateTypeService();
}
