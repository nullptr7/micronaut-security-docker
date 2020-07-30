package org.bitbucket.nullptr7.repo;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.bitbucket.nullptr7.models.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
