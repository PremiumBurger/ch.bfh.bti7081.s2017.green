package ch.bfh.bti7081.s2017.green.ui.components.login;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Login {

    private HealthVisitorService service;

    @Autowired
    public Login(HealthVisitorService service) {
        this.service = service;
    }

    public HealthVisitorBean getFirstVisitor() {
        return service.getOne(1);
    }
}
