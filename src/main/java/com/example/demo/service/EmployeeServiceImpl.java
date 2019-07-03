package com.example.demo.service;

import com.example.demo.com.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("invalid id"+id));
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByEmployeeID(int id) {
       Optional<Employee> emp = employeeRepository.findById(id);

       if(emp.isPresent()){
           return emp.get();
       }else {
           throw new RuntimeException("invalid id"+id);
       }
    }

}
