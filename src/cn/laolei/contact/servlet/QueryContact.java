package cn.laolei.contact.servlet;

import cn.laolei.contact.entity.Contact;
import cn.laolei.contact.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lailei
 * @date 2020/2/27 23:39
 */

public class QueryContact extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        ContactServiceImpl service = new ContactServiceImpl();
        String userName = request.getParameter("userName");
        List<Contact> list = service.findByName(name, userName);
        if (!list.isEmpty()) {
            request.setAttribute("list", list);
            request.getRequestDispatcher("/ShowContact.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/ListContact.jsp");
        }
    }
}
