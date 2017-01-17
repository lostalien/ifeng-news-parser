package my.vaadin.scims;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hxj on 2017/1/15.
 */
public class NavigatorUI extends UI {

    Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        getPage().setTitle("Navigation Example");
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        // Create and register the views
        navigator.addView("", new LoginView(navigator));
        navigator.addView("main", new MainView());

    }
}
