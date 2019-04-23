package com.company;

import com.company.dao.CompanyDao;
import com.company.dao.UserDao;
import com.company.entity.User;
import com.company.service.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        User user = new User("Kate", "Oooo", 10000);
//        UserService userService = new UserService();
//        userService.createWithCompanyName(user);


        UserDao userDao = new UserDao();
//        CompanyDao companyDao = new CompanyDao();
//        Company company = new Company(5, "Eee");
//        List<Company> companies = companyDao.findAll();
//        for (Company company : companies) {
//            System.out.println(company.getId() + "|" + company.getName());
//        }

        List<User> users = userDao.findByName("Vova");
        for (User user : users) {
            System.out.println(user.getId() + "|" + user.getName() + "|" + user.getCompany() + "|" + user.getSalary());
        }

    }
}
