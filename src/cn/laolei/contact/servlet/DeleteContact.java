package cn.laolei.contact.servlet;

import cn.laolei.contact.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lailei
 * @date 2020/2/27 21:40
 */
public class DeleteContact extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ContactServiceImpl service = new ContactServiceImpl();
        service.deleteContact(id);
        response.sendRedirect(request.getContextPath() + "/ListContact");
    }
}
