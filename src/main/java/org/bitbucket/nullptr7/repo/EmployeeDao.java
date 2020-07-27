package org.bitbucket.nullptr7.repo;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.bitbucket.nullptr7.models.Employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
