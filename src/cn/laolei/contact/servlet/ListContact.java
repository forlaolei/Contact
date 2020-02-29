package cn.laolei.contact.servlet;

import cn.laolei.contact.entity.Contact;
import cn.laolei.contact.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author lailei
 * @date 2020/2/27 15:50
 * <p>
 * 显示联系人
 */
public class ListContact extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactServiceImpl daoService = new ContactServiceImpl();
        String userName = request.getParameter("userName");
        List<Contact> list = daoService.findAll(userName);
        HttpSession session = request.getSession();
        session.setAttribute("list", list);
        // 重定向会新建request
        // response.sendRedirect(request.getContextPath() + "/ListContact.jsp");
        request.setAttribute("userName", userName);
        request.getRequestDispatcher("/ListContact.jsp").forward(request, response);

    }
}
