package my.vaadin.scims;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by redemption on 2017/1/16.
 */
public class InitDBServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //读取初始化脚本

        try(InputStream is = this.getClass().getResourceAsStream("init.sql");
             ){
            URL url = this.getClass().getClassLoader().getResource("init.sql");
            System.out.println(url.toString());
            //System.out.println("初始化脚本是否可用：" + is.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection("jdbc:h2:mem:test") ){
            System.out.println("数据库名：" + conn.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
