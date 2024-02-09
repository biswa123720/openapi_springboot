package com.java.APIIntegration.Controller;

import com.java.APIIntegration.Model.Employee;
import com.java.APIIntegration.Service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/getAllEmployee")
    public ResponseEntity<String> getAllEmployee(){
        return restTemplateService.allEmployee();
    }
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return restTemplateService.createEmployee(employee);
    }
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return restTemplateService.getEmployeeById(id);
    }
    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        restTemplateService.updateEmployee(employee);
    }
}
