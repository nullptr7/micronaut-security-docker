package org.bitbucket.nullptr7.repo;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.bitbucket.nullptr7.models.Address;

@Repository
public interface AddressDao extends CrudRepository<Address, Integer> {

}
