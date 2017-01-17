package my.vaadin.scims;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


/**
 * Created by redemption on 2017/1/13.
 */
class LoginView extends GridLayout implements View{
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("这是登录页！");
    }


    public LoginView( Navigator navigator ) {
        super(3, 3);
        this.setSizeFull();

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
                navigator.navigateTo("main");
            }
        });

        formLayout.addComponent(unameField);
        formLayout.addComponent(pwdField);
        formLayout.addComponent(loginBtn);

        this.addComponent(formLayout,1,1);
    }
}
