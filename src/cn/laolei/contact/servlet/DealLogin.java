package cn.laolei.contact.servlet;

import cn.laolei.contact.util.JdbcException;
import cn.laolei.contact.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lailei
 * @date 2020/2/27 13:40
 * <p>
 * 处理用户登录
 */
public class DealLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String sql = "select * from user where userName=? and password=?;";
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connect = JdbcUtil.getConnect();
            // 预编译sql
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            // 移动光标，判断结果集
            if (resultSet.next()) {
                if (resultSet.getString("userName").equals(userName) &&
                        resultSet.getString("password").equals(password)) {
                    // 重定向
                    resp.sendRedirect(req.getContextPath() + "/ListContact?userName=" + userName);
                } else {
                    // 重定向
                    resp.sendRedirect(req.getContextPath() + "/loginFail.jsp");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/loginFail.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcException.tryCatch(resultSet, preparedStatement, connect);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
