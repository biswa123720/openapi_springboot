package com.java.APIIntegration.Service;

import com.java.APIIntegration.Model.Employee;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestTemplateService {
    RestTemplate restTemplate=new RestTemplate();

    private static final String get_all_employee_url="http://localhost:8080/apiIntegration/getAllEmployee";
    private static final String create_employee_url="http://localhost:8080/apiIntegration/addEmployee";

    private static final String get_employee_url_by_id="http://localhost:8080/apiIntegration/getEmployee/{id}";

    private static final String update_employee_url="http://localhost:8080/apiIntegration/updateEmployee";
    public ResponseEntity<String> allEmployee(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<String>("parameters",headers);
        return restTemplate.exchange(get_all_employee_url, HttpMethod.GET,entity,String.class);
    }

    public ResponseEntity<Employee> createEmployee(Employee employee){
        return restTemplate.postForEntity(create_employee_url,employee,Employee.class);
    }

    public Employee getEmployeeById(Long id) {
        Map<String,Long> param=new HashMap<String, Long>();
        param.put("id",id);
        return restTemplate.getForObject(get_employee_url_by_id,Employee.class,param);
    }

    public void updateEmployee(Employee employee) {
        restTemplate.put(update_employee_url,employee);
    }
}
