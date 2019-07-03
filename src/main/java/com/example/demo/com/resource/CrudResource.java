package com.example.demo.com.resource;

import com.example.demo.com.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CrudResource {

    @Autowired
    private EmployeeService employeeService;

    @Value("${app.name}")
    private String appName;


    @GetMapping
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployeeByID(@PathVariable int id){

        return employeeService.findByEmployeeID(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        Employee empObject = employeeService.saveEmp(employee);
        return empObject;
    }
    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        Employee byEmployeeID = employeeService.findByEmployeeID(id);
        if (byEmployeeID==null){
            throw new RuntimeException("not found the record for update"+id);
        }else {
            employee.setId(byEmployeeID.getId());
            Employee updatedEmployee = employeeService.saveEmp(employee);
            return updatedEmployee;
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }



}
