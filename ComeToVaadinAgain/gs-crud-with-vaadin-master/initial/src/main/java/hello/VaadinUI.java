package hello;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

/**
 * Created by redemption on 2016/11/24.
 */
@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private CustomerRepository repo;
    private Grid grid;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Button("Click me", e-> Notification.show("Hello Spring+Vaadin user!")));
    }
}
