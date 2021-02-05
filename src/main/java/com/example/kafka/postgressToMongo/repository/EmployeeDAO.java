package com.example.kafka.postgressToMongo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDAO {
    String id;
    String emp_age;
    String emp_dept;
    String empfname;
    String emplname;
    String InsuranceStatus;
}
