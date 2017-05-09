package ch.bfh.bti7081.s2017.green.ui.components.login;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by joris on 08.05.17.
 */
public class Login {
    private HealthVisitorService service;

    public Login(HealthVisitorService service) {
        this.service = service;
    }

    public HealthVisitorBean getFirstVisitor(){
        return service.getOne(1);
    }
}
