package cn.laolei.contact.servlet;

import cn.laolei.contact.entity.Contact;
import cn.laolei.contact.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lailei
 * @date 2020/2/28 1:41
 */
public class UpdateContact extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        Contact contact = new Contact(id, name, age, gender, phone, qq, email);
        ContactServiceImpl service = new ContactServiceImpl();
        service.UpdateContact(contact);
        response.sendRedirect(request.getContextPath() + "/ListContact");
    }
}
