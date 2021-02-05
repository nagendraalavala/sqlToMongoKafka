package com.example.kafka.postgressToMongo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class SQLRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String sqlQueryForGetAllEmployee = "select * from employee.employee_entity";

    public List<EmployeeDAO> getAllEmployeeDetails(){
        return jdbcTemplate.query(sqlQueryForGetAllEmployee,new BeanPropertyRowMapper<>(EmployeeDAO.class));
    }
}
