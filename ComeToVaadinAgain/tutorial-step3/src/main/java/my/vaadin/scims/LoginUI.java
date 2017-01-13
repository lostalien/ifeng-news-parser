package my.vaadin.scims;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import my.vaadin.app.Customer;
import my.vaadin.app.CustomerForm;
import my.vaadin.app.CustomerService;

import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class LoginUI extends UI {

    // Add the next two lines:
    private CustomerService service = CustomerService.getInstance();
    private TextField filterText = new TextField();

    //private CustomerForm form = new CustomerForm(this);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        GridLayout gridLayout = new GridLayout(3,3);
        gridLayout.setSizeFull();

        FormLayout formLayout = new FormLayout();
        formLayout.setSizeUndefined();
        //用户名
        TextField unameField = new TextField("用户名");
        unameField.setRequired(true);
        unameField.setRequiredError("用户名不能为空");
        //密码
        PasswordField pwdField = new PasswordField("密码");
        pwdField.setRequired(true);
        pwdField.setRequiredError("密码不能为空");
        //登录按钮
        Button loginBtn = new Button("登录");
        loginBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                System.out.println( "用户名：" + unameField.getValue() );
                System.out.println( "密码：" + pwdField.getValue() );
            }
        });

        formLayout.addComponent(unameField);
        formLayout.addComponent(pwdField);
        formLayout.addComponent(loginBtn);

        gridLayout.addComponent( formLayout,1,1);
        setContent(gridLayout);
    }


/*    @WebServlet(urlPatterns = "*//*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet2 extends VaadinServlet {
    }*/
}
