package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.LocationBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppointmentDetailPresenter implements AppointmentDetailViewListener {

    private AppointmentDetailModel appDetailModel;
    private AppointmentDetailView appDetailView;

    @Autowired
    public AppointmentDetailPresenter(AppointmentDetailModel appDetailModel, AppointmentDetailView appDetailView) {
        this.appDetailModel = appDetailModel;
        this.appDetailView = appDetailView;
        appDetailView.setListener(this);
    }

    @Override
    public void initScreen(long appointmentId) {
        AppointmentBean foundBean = appDetailModel.getAppointment(appointmentId);
        Set<PatientBean> allPatients = appDetailModel.getAllPatients();
        Set<AppointmentStateTypeBean> allAppointmentStateTypes = appDetailModel.getAllAppointmentStateTypes();
        LocationBean locationBean = appDetailModel.getLocationBean(foundBean.getAddress());
        appDetailView.setModel(foundBean, allPatients, allAppointmentStateTypes, locationBean);
    }

    @Override
    public void saveAppointment(AppointmentBean appointmentBean) {
        //appointmentBean.getAppointmentStateType().getAppointmentState().beforeStateSet(appointmentBean,this);
        AppointmentBean oldBean = appointmentBean;
        long savedAppointmentId = appDetailModel.saveAppointment(appointmentBean);
        if (savedAppointmentId>0){
            appointmentBean.getAppointmentStateType().getAppointmentState().afterStateSet(appDetailModel.getAppointment(savedAppointmentId),oldBean,this);
        }

    }

    @Override
    public void onConfirmClicked(AppointmentBean appointmentBean) {
        appointmentBean.getAppointmentStateType().getAppointmentState().confirm(appointmentBean,this);
    }

    @Override
    public void onCancelledClicked(AppointmentBean appointmentBean) {
        appointmentBean.getAppointmentStateType().getAppointmentState().remove(appointmentBean,this);
    }

    public void updateConfirmButton(boolean visible, String buttonCaption) {
        appDetailView.updateConfirmButton(visible,buttonCaption);
    }


    public void updateCancelButton(boolean visible, String buttonCaption) {
        appDetailView.updateCancelButton(visible,buttonCaption);
    }

    /**
     * Getter for
     * @return AppointmentStateTypeBean
     */
    public AppointmentStateTypeBean getAppointmentStateTypeBean(long id) {
        return appDetailModel.getAppointmentStateTypeBean(id);
    }
}
