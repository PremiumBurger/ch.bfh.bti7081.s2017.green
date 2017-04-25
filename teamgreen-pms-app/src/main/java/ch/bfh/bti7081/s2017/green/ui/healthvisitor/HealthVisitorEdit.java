package ch.bfh.bti7081.s2017.green.ui.healthvisitor;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Cedric on 23.04.2017.
 */

@SpringComponent
@UIScope
public class HealthVisitorEdit extends VerticalLayout {

    @Autowired
    private HealthVisitorService healthVisitorService;

    private HealthVisitorBean healthVisitor;

    /* Fields to edit properties in HealthVisitor entity */
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");

    /* Action buttons */
    Button save = new Button("Save", VaadinIcons.DISC);
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcons.TRASH);
    CssLayout actions = new CssLayout(save, cancel, delete);

    Binder<HealthVisitorBean> binder = new BeanValidationBinder<>(HealthVisitorBean.class);

    public HealthVisitorEdit() {


        addComponents(firstName, lastName, actions);

        // bind using naming convention
        binder.bindInstanceFields(this);

        // Configure and style components
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> healthVisitorService.save(healthVisitor));
        delete.addClickListener(e -> healthVisitorService.delete(healthVisitor));
        cancel.addClickListener(e -> cancelEditHealthVisitor());
        setVisible(false);

    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editHealthVisitor(HealthVisitorBean h) {
        if (h == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = h.getHealthVisitorId() != null;
        if (persisted) {
            // Find fresh entity for editing
            this.healthVisitor = healthVisitorService.getOne(h.getHealthVisitorId());
        } else {
            this.healthVisitor = h;
        }
        delete.setVisible(persisted);

        // Bind health visitor properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(this.healthVisitor);

        setVisible(true);

        save.focus();

        // Select all text in firstName field automatically
        firstName.selectAll();
    }

    public final void cancelEditHealthVisitor() {
        healthVisitor = null;
        setVisible(false);
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        save.addClickListener(e -> h.onChange());
        delete.addClickListener(e -> h.onChange());
    }
}
