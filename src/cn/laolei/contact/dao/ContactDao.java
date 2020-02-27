package cn.laolei.contact.dao;

import cn.laolei.contact.entity.Contact;

import java.util.List;

/**
 * @author lailei
 * @date 2020/2/27 15:16
 */
public interface ContactDao {
    /**
     * 查询所有联系人
     *
     * @return
     */
    List<Contact> findAll();

    /**
     * 增加联系人
     *
     * @param contact
     */
    void addContact(Contact contact);

    /**
     * 删除联系人
     *
     * @param id
     */
    void deleteContact(int id);

    /**
     * 通过id查找联系人
     *
     * @param name
     * @return
     */
    List<Contact> findByName(String name);

    /**
     * 修改联系人
     *
     * @param contact
     */
    void UpdateContact(Contact contact);
}
