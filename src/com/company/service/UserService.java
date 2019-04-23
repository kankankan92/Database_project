package com.company.service;

import com.company.dao.CompanyDao;
import com.company.dao.UserDao;
import com.company.entity.Company;
import com.company.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();
    private CompanyDao companyDao = new CompanyDao();

    public void createWithCompanyName(User user) {
        if (!companyDao.checkExistenceCompany(user.getCompany())) {
            Company company = new Company(user.getCompany());
            companyDao.create(company);
            company = companyDao.findByName(user.getCompany());
            userDao.create(user, company.getId());
        } else {
            Company company = companyDao.findByName(user.getCompany());
            userDao.create(user, company.getId());
        }
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public List<User> findByName(String name){
        return userDao.findByName(name);
    }


}