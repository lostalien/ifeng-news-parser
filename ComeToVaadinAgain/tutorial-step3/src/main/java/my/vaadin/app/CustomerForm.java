package my.vaadin.app;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by redemption on 2016/11/23.
 */
public class CustomerForm extends FormLayout {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");
    private NativeSelect status = new NativeSelect("Status");
    private PopupDateField birthdate = new PopupDateField("Birthday");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private CustomerService service = CustomerService.getInstance();
    private Customer customer;
    private MyUI myUI;

    public CustomerForm(MyUI myUI) {
        this.myUI = myUI;

        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        buttons.setSpacing(true);
        addComponents(firstName, lastName, email, status, birthdate, buttons);
        status.addItems(CustomerStatus.values());

        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        save.addClickListener(e->this.save());
        delete.addClickListener(e->this.delete());

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        BeanFieldGroup.bindFieldsUnbuffered(customer, this);

        // Show delete button for only customers already in the database
        delete.setVisible(customer.isPersisted());
        setVisible(true);
        firstName.selectAll();
    }

    private void delete() {
        service.delete(customer);
        myUI.updateList();
        setVisible(false);
    }

    private void save() {
        service.save(customer);
        myUI.updateList();
        setVisible(false);
    }

}
