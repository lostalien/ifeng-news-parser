package my.vaadin.scims;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import my.vaadin.app.MyUI;

import javax.servlet.annotation.WebServlet;

/**
 * Created by redemption on 2016/12/8.
 */
@WebServlet(urlPatterns = "/*", name = "LoginUIServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = NavigatorUI.class, productionMode = false)
public class LoginUIServlet extends VaadinServlet {
}
