package cn.laolei.contact.dao.impl;

import cn.laolei.contact.dao.ContactDao;
import cn.laolei.contact.entity.Contact;
import cn.laolei.contact.util.JdbcException;
import cn.laolei.contact.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lailei
 * @date 2020/2/27 15:17
 */
public class ContactDaoImpl implements ContactDao {
    @Override
    public List<Contact> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from contact";
        List<Contact> list;
        try {
            connection = JdbcUtil.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String qq = resultSet.getString("QQ");
                String email = resultSet.getString("email");
                Contact contact = new Contact();
                contact.setId(id);
                contact.setName(name);
                contact.setAge(age);
                contact.setGender(gender);
                contact.setPhone(phone);
                contact.setQq(qq);
                contact.setEmail(email);
                list.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcException.tryCatch(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public void addContact(Contact contact) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into contact(name, age, gender, phone, QQ, email) VALUES (?,?,?,?,?,?);";
        try {
            connection = JdbcUtil.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setInt(2, contact.getAge());
            preparedStatement.setString(3, contact.getGender());
            preparedStatement.setString(4, contact.getPhone());
            preparedStatement.setString(5, contact.getQq());
            preparedStatement.setString(6, contact.getEmail());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcException.tryCatch(preparedStatement, connection);
        }
    }

    @Override
    public void deleteContact(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from contact where id=?;";
        try {
            connection = JdbcUtil.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcException.tryCatch(preparedStatement, connection);
        }
    }

    @Override
    public List<Contact> findByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from contact where name=?";
        List<Contact> list = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact();
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String qq = resultSet.getString("QQ");
                String email = resultSet.getString("email");
                contact.setId(id);
                contact.setName(name);
                contact.setAge(age);
                contact.setGender(gender);
                contact.setPhone(phone);
                contact.setQq(qq);
                contact.setEmail(email);
                list.add(contact);
            }
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcException.tryCatch(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public void UpdateContact(Contact contact) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update contact set name=?,age=?,gender=?,phone=?,QQ=?,email=? where id=?;";
        try {
            connection = JdbcUtil.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setInt(2, contact.getAge());
            preparedStatement.setString(3, contact.getGender());
            preparedStatement.setString(4, contact.getPhone());
            preparedStatement.setString(5, contact.getQq());
            preparedStatement.setString(6, contact.getEmail());
            preparedStatement.setInt(7, contact.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcException.tryCatch(preparedStatement, connection);
        }
    }
}
