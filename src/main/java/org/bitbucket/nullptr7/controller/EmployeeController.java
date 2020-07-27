package org.bitbucket.nullptr7.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bitbucket.nullptr7.models.Employee;
import org.bitbucket.nullptr7.repo.EmployeeDao;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@Controller("/employee")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class EmployeeController {

    @Inject
    private EmployeeDao employeeDao;


    @Get("/allOne")
    @Tag(name = "employees")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @ApiResponse(responseCode = "404", description = "No Employees")
    @ApiResponse(responseCode = "400", description = "Invalid response")
    @Operation(summary = "Gives back all the employees", description = "Will return list of employees")
    public List<Employee> getAllOne() {
        return (List<Employee>) employeeDao.findAll();
    }


    @Get("/by/{id}")
    @Tag(name = "employee")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @ApiResponse(responseCode = "404", description = "No Employees")
    @ApiResponse(responseCode = "400", description = "Invalid response")
    @Operation(summary = "Gives back the given employee by its Id", description = "Will return employee")
    public Employee getEmployeeById(Integer id) {
        final Optional<Employee> employeeOptional = employeeDao.findById(id);
        return employeeOptional.orElse(null);
    }
}
