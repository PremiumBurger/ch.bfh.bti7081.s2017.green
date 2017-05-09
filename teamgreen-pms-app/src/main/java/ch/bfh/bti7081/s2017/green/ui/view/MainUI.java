package ch.bfh.bti7081.s2017.green.ui.view;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.domain.builder.HealthVisitorBuilder;
import ch.bfh.bti7081.s2017.green.service.AddressService;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import ch.bfh.bti7081.s2017.green.ui.view.main.MainViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by joris on 08.05.17.
 */
@SpringUI
@Theme("valo")
public class MainUI extends UI {

    @Autowired
    private HealthVisitorService hService;

    @Autowired
    private AddressService aService;

    @Override
    protected void init(VaadinRequest request) {
        setContent(new MainViewImpl());
        setUp();

        // Set<HealthVisitorBean> all = hService.getAll();
        Set<AddressBean> alltAddr = aService.getAll();

    }


    private void setUp() {
        HealthVisitor build = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        HealthVisitorBean bean = new HealthVisitorBean();
        bean.setEntity(build);
        hService.save(bean);
    }
}
