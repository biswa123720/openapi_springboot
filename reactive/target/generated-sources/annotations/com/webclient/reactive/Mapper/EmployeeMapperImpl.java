package com.webclient.reactive.Mapper;

import com.webclient.reactive.Entity.Employee;
import com.webclient.reactive.Model.EmployeeResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-11T13:18:08+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeResponse mapToEmployeeResponse(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId( employee.getId() );
        employeeResponse.setName( employee.getName() );
        employeeResponse.setEmail( employee.getEmail() );
        employeeResponse.setAge( employee.getAge() );

        return employeeResponse;
    }
}
