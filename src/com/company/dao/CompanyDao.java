package com.company.dao;

import com.company.JdbcHelper;
import com.company.entity.Company;
import com.company.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.company.JdbcHelper.getResult;

public class CompanyDao {

    public void create(Company company) {
        String query = "insert into companies (id, name) values (:id, ':name');"
                .replace(":id", String.valueOf(getNextId()))
                .replace(":name", company.getName());
        JdbcHelper.runQuery(query);
    }

    public List<Company> findAll(){
        List<Company> companies = new LinkedList<>();
        String query = "select * from companies;";
        ResultSet resultSet =  JdbcHelper.getResult(query);
        try {
            while (resultSet.next()){
            Company company = new Company(resultSet.getInt("id"), resultSet.getString("name"));
            companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    private int getNextId(){
        String query = "select nextval ('company_id')";
        ResultSet rs = JdbcHelper.getResult(query);
        try {
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Company findByName(String name) {
        String query = "select * from companies where name = '" + name + "';";
        ResultSet rs = JdbcHelper.getResult(query);
        Company company=null;
        try {
            while (rs.next()) {
                company = new Company(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public boolean checkExistenceCompany(String name) {
        String query = "select count(*) from companies where name = '" + name + "';";
        ResultSet rs = JdbcHelper.getResult(query);
        boolean check = false;
        try {
            rs.first();
            check = rs.getInt(1) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

}
