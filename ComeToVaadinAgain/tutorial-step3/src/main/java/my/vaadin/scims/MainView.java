package my.vaadin.scims;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by hxj on 2017/1/15.
 */
public class MainView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("这里主界面！");
    }

    public MainView() {
        TextField tf = new TextField("哟哈");
        this.addComponent(tf);
    }
}
