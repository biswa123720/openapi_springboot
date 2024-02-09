package com.java.APIIntegration.Service;

import com.java.APIIntegration.Model.Employee;
import com.java.APIIntegration.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee employee) {
        Employee updatedEmployee=new Employee();
        updatedEmployee.setDepartment(employee.getDepartment());
        updatedEmployee.setId(employee.getId());
        updatedEmployee.setName(employee.getName());
        return employeeRepository.save(updatedEmployee);
    }
}
