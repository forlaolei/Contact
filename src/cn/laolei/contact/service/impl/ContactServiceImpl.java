package cn.laolei.contact.service.impl;

import cn.laolei.contact.dao.impl.ContactDaoImpl;
import cn.laolei.contact.entity.Contact;
import cn.laolei.contact.service.ContactService;

import java.util.List;

/**
 * @author lailei
 * @date 2020/2/27 15:44
 */
public class ContactServiceImpl implements ContactService {
    ContactDaoImpl dao = new ContactDaoImpl();

    @Override
    public List<Contact> findAll(String userName) {
        return dao.findAll(userName);
    }

    @Override
    public void addContact(Contact contact, String userName) {
        dao.addContact(contact, userName);
    }

    @Override
    public void deleteContact(int id, String userName) {
        dao.deleteContact(id, userName);
    }

    @Override
    public List<Contact> findByName(String name, String userName) {
        return dao.findByName(name, userName);
    }

    @Override
    public void UpdateContact(Contact contact, String userName) {
        dao.UpdateContact(contact, userName);
    }
}
