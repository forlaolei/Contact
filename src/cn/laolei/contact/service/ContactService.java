package cn.laolei.contact.service;

import cn.laolei.contact.entity.Contact;

import java.util.List;

/**
 * @author lailei
 * @date 2020/2/27 15:42
 */
public interface ContactService {
    /**
     * 查询所有联系人
     *
     * @param userName
     * @return
     */
    List<Contact> findAll(String userName);

    /**
     * 增加联系人
     *
     * @param contact
     * @param userName
     */
    void addContact(Contact contact, String userName);

    /**
     * 删除联系人
     *
     * @param id
     * @param userName
     */
    void deleteContact(int id, String userName);

    /**
     * 通过name查找联系人
     *
     * @param userName
     * @param name
     * @return
     */
    List<Contact> findByName(String name, String userName);

    /**
     * 修改联系人
     *
     * @param contact
     * @param userName
     */
    void UpdateContact(Contact contact, String userName);
}
