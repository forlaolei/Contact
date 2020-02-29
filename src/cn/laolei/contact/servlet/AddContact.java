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
 * @date 2020/2/27 20:11
 */
public class AddContact extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        System.out.println("yhm" + userName);
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String qq = request.getParameter("QQ");
        String email = request.getParameter("email");
        Contact contact = new Contact();
        contact.setName(name);
        try {
            contact.setAge(Integer.parseInt(age));
        } catch (Exception e) {
            request.getRequestDispatcher("/AgeException.jsp?userName=" + userName).forward(request, response);
            e.printStackTrace();
            return;
        }
        contact.setGender(gender);
        contact.setPhone(phone);
        contact.setQq(qq);
        contact.setEmail(email);
        ContactServiceImpl service = new ContactServiceImpl();
        service.addContact(contact, userName);
        request.getRequestDispatcher("/ListContact").forward(request, response);
    }

}
