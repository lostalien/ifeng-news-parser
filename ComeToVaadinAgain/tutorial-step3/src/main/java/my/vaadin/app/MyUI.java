package my.vaadin.app;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    // Add the next two lines:
    private CustomerService service = CustomerService.getInstance();
    private Grid grid = new Grid();
    private TextField filterText = new TextField();

    private CustomerForm form = new CustomerForm(this);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue()
                    + ", it works!"));
        });

        grid.setColumns("firstName", "lastName", "email");
        grid.addSelectionListener(event -> {
            if (event.getSelected().isEmpty()) {
                form.setVisible(false);
            } else {
                Customer customer = (Customer) event.getSelected().iterator().next();
                form.setCustomer(customer);
            }
        });
        grid.setSizeFull();

        filterText.setInputPrompt("filter by name...");
        filterText.addTextChangeListener(e -> {
            grid.setContainerDataSource(new BeanItemContainer<>(Customer.class,
                    service.findAll(e.getText())));
        });

        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> {
            filterText.clear();
            updateList();
        });

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
            grid.select(null);
            form.setCustomer(new Customer());
        });
        HorizontalLayout toolbar = new HorizontalLayout(filtering, addCustomerBtn);
        toolbar.setSpacing(true);

        updateList();

        layout.addComponents(name, button);
        // add Grid to the layout
        HorizontalLayout main = new HorizontalLayout(grid, form);
        form.setVisible(false);
        main.setSpacing(true);
        main.setSizeFull();

        main.setExpandRatio(grid, 1);

        layout.addComponents(toolbar, main);

        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
    }

    /**
     * fetch list of Customers from service and assign it to Grid
     */
    public void updateList() {
        List<Customer> customers = service.findAll();
        grid.setContainerDataSource(new BeanItemContainer<>(Customer.class, customers));
    }

/*    @WebServlet(urlPatterns = "*//*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet2 extends VaadinServlet {
    }*/
}
