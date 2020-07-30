package org.bitbucket.nullptr7.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bitbucket.nullptr7.models.Employee;
import org.bitbucket.nullptr7.repo.AddressDao;
import org.bitbucket.nullptr7.repo.EmployeeDao;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Validated
@Controller("/employee")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class EmployeeController {

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private AddressDao addressDao;

    @Get("/allOne")
    @Tag(name = "employees")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @ApiResponse(responseCode = "200", description = "Ok")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @Operation(summary = "Gives back all the employees", description = "Will return list of employees")
    public List<Employee> getAllOne() {
        return (List<Employee>) employeeDao.findAll();
    }

    @Get("/by/{id}")
    @Tag(name = "employee")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @ApiResponse(responseCode = "200", description = "Ok")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @Operation(summary = "Gives back the given employee by its Id", description = "Will return employee")
    public Employee getEmployeeById(Integer id) {
        final Optional<Employee> employeeOptional = employeeDao.findById(id);
        return employeeOptional.orElse(null);
    }

    @Post("/add")
    @Tag(name = "add employee")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @ApiResponse(responseCode = "200", description = "Ok")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @Operation(summary = "Add an employee to database", description = "Will added return employee")
    public Employee saveEmployee(@NotNull Employee employee) {
        if (employee.getAddress() != null)
            addressDao.save(employee.getAddress());
        return employeeDao.save(employee);
    }
}
