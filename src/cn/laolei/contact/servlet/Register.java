package cn.laolei.contact.servlet;

import cn.laolei.contact.util.JdbcException;
import cn.laolei.contact.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lailei
 * @date 2020/2/29 15:37
 */
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;utf-8");
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        // 用户名不能出现中文
        Pattern compile = Pattern.compile("[0-9A-Za-z]");
        Matcher matcher = compile.matcher(userName);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        // 密码不能为空
        if (count == 0 || password == null) {
            response.sendRedirect(request.getContextPath() + "/RegisterFail.jsp");
            return;
        }
        String sql = "select userName from user;";
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Statement statement;
        try {
            connect = JdbcUtil.getConnect();
            // 预编译sql
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<String> arrList = new ArrayList<>();
            while (resultSet.next()) {
                String userName1 = resultSet.getString("userName");
                arrList.add(userName1);
            }
            if (!arrList.contains(userName)) {
                String sql2 = "insert into user(userName,password) values(?,?);";
                preparedStatement = connect.prepareStatement(sql2);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                response.sendRedirect(request.getContextPath() + "/RegisterSuccessful.jsp");
                // 为每个注册用户创建联系人表
                String sql3 = "create table contact_" + userName + " (id int zerofill auto_increment primary key,name varchar(10),age int,gender varchar(2),phone varchar(11),QQ varchar(11), email varchar(30));";
                statement = connect.createStatement();
                statement.executeUpdate(sql3);
                statement.close();
            } else {
                response.sendRedirect(request.getContextPath() + "/RegisterFail.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcException.tryCatch(resultSet, preparedStatement, connect);
        }
    }
}
