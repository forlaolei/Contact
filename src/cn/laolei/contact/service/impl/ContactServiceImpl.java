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
    public List<Contact> findAll() {
        return dao.findAll();
    }

    @Override
    public void addContact(Contact contact) {
        dao.addContact(contact);
    }

    @Override
    public void deleteContact(int id) {
        dao.deleteContact(id);
    }

    @Override
    public List<Contact> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void UpdateContact(Contact contact) {
        dao.UpdateContact(contact);
    }
}
