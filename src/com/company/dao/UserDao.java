package com.company.dao;

import com.company.JdbcHelper;
import com.company.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void create(User user, int company_id) {
        String query = "insert into users (id, name, company_id, salary) values (:id, ':name', :company_id, ':salary');"
                .replace(":id", String.valueOf(getNextId()))
                .replace(":name", user.getName())
                .replace(":company_id", String.valueOf(company_id))
//                .replace(":company", user.getCompany())
                .replace(":salary", String.valueOf(user.getSalary()));
        JdbcHelper.runQuery(query);
    }

    public List<User> findAll() {
        String query = "select u.id, u.name, c.name as company, u.salary from users u left join companies c on c.id = u.company_id";
        ResultSet rs = JdbcHelper.getResult(query);
        List<User> userList = new ArrayList<>();
        try {
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("company"), rs.getInt("salary"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public List<User> findByName(String name) {
        String query = "select u.id, u.name, c.name as company, u.salary from users u left join companies c on c.id = u.company_id where u.name = '" + name + "';";
        ResultSet rs = JdbcHelper.getResult(query);
        List<User> userList = new ArrayList<>();
        try {
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("company"), rs.getInt("salary"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

//    public boolean checkExistenceUser(String name) {
//        String query = "select count(*) from users where name = '" + name + "';";
//        ResultSet rs = JdbcHelper.getResult(query);
//        boolean check = false;
//        try {
//            rs.first();
//            check = rs.getInt(1) == 1;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return check;
//    }

    private int getNextId(){
        String query = "select nextval ('user_id')";
        ResultSet rs = JdbcHelper.getResult(query);
        try {
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


//
//
//    public void deleteUser(String name) {
//        MessageDao messageDao = new MessageDao();
//        messageDao.deleteAllMessagesUser(name);
//        String query = "delete from users where name = '" + name + "';";
//        JdbcHelper.runQuery(query);
//    }


}
