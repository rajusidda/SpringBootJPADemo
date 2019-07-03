package com.example.demo.service;

import com.example.demo.com.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmp(Employee employee);

    Employee getEmployeeByID(int id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee findByEmployeeID(int id);
}
