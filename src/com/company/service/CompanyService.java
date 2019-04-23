package com.company.service;

import com.company.dao.CompanyDao;
import com.company.dao.UserDao;
import com.company.entity.Company;

import java.util.List;

public class CompanyService {

    private UserDao userDao = new UserDao();
    private CompanyDao companyDao = new CompanyDao();

    public void create(Company company){
        companyDao.create(company);
    }

    public List<Company> findAll(){
       return companyDao.findAll();
    }

    public Company findByName(String name) {
        return companyDao.findByName(name);
    }


}
