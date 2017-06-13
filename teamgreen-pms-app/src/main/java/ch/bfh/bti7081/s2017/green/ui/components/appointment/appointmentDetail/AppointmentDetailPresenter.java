package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.*;
import ch.bfh.bti7081.s2017.green.domain.AppointmentJournalEntry;
import ch.bfh.bti7081.s2017.green.bean.LocationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AppointmentDetailPresenter implements AppointmentDetailViewListener {

    private AppointmentDetailModel appDetailModel;
    private AppointmentDetailView appDetailView;
    private final static Logger LOGGER = Logger.getLogger(AppointmentDetailPresenter.class.getName());

    @Autowired
    public AppointmentDetailPresenter(AppointmentDetailModel appDetailModel, AppointmentDetailView appDetailView) {
        this.appDetailModel = appDetailModel;
        this.appDetailView = appDetailView;
        appDetailView.setListener(this);
        LOGGER.setLevel(Level.INFO);
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
        long savedAppointmentId = appDetailModel.saveAppointment(appointmentBean);
        if (savedAppointmentId>0){
            appointmentBean.getAppointmentStateType().getAppointmentState().afterStateSet(appDetailModel.getAppointment(savedAppointmentId),appointmentBean,this);
        }
		LOGGER.info("Das Appointment wurde soeben gespeichert");
    }

    @Override
    public void onConfirmClicked(AppointmentBean appointmentBean) {
        appointmentBean.getAppointmentStateType().getAppointmentState().confirm(appointmentBean,this);
        saveAppointment(appointmentBean);
    }

    @Override
    public void onCancelledClicked(AppointmentBean appointmentBean) {
        appointmentBean.getAppointmentStateType().getAppointmentState().remove(appointmentBean,this);
        saveAppointment(appointmentBean);
    }

    @Override
    public void getStateRefresh(AppointmentBean appointmentBean) {
        appointmentBean.getAppointmentStateType().getAppointmentState().afterStateSet(appointmentBean,appointmentBean,this);
    }

    /**
     *  update the state-dependent buttons on the view
     * @param confirmButtonVisible sets confirm button visible/invisible
     * @param confirmButtonCaption sets caption of the confirm button
     * @param cancelButtonVisible sets cancel button visible/invisible
     * @param cancelButtonCaption sets caption of cancel button
     */
    public void updateStateButtons(boolean confirmButtonVisible, String confirmButtonCaption, boolean cancelButtonVisible, String cancelButtonCaption) {
        appDetailView.updateStateButtons(confirmButtonVisible,confirmButtonCaption,cancelButtonVisible,cancelButtonCaption);
    }

    /**
     * Getter for
     * @return AppointmentStateTypeBean
     */
    public AppointmentStateTypeBean getAppointmentStateTypeBean(long id) {
        return appDetailModel.getAppointmentStateTypeBean(id);
    }

    @Override
    public void onAddJournalEntryButtonClick(){
        AppointmentJournalEntryBean appointmentJournalEntryBean = new AppointmentJournalEntryBean();
        this.appDetailView.openModal(appointmentJournalEntryBean);
    }
}
