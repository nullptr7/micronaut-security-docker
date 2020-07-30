package org.bitbucket.nullptr7.init;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceReadyEvent;
import org.bitbucket.nullptr7.models.Address;
import org.bitbucket.nullptr7.models.Employee;
import org.bitbucket.nullptr7.repo.AddressDao;
import org.bitbucket.nullptr7.repo.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class DataLoader implements ApplicationEventListener<ServiceReadyEvent> {

    private final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);
    private final EmployeeDao EMP_DAO;
    private final AddressDao ADD_DAO;

    public DataLoader(EmployeeDao employeeDao, AddressDao addressDao) {
        this.EMP_DAO = employeeDao;
        this.ADD_DAO = addressDao;
    }

    @Override
    public void onApplicationEvent(ServiceReadyEvent event) {

        LOGGER.info("Application started.");
        LOGGER.info("Data entry in progress...");

        if (EMP_DAO.findAll()
                   .iterator()
                   .hasNext()) {
            LOGGER.info("Elements are available. Existing...");
            return;
        }
        Employee e1 = Employee.builder()
                              .name("Employee1")
                              .salary(100.00)
                              .address(ADD_DAO.save(
                                      Address.builder()
                                             .addressLine1("AddLine1")
                                             .addressLine2("AddLine2")
                                             .build()))
                              .build();
        Employee e2 = Employee.builder()
                              .name("Employee2")
                              .salary(300.00)
                              .address(ADD_DAO.save(
                                      Address.builder()
                                             .addressLine1("AddLine11")
                                             .addressLine2("AddLine21")
                                             .build()))
                              .build();
        Employee e3 = Employee.builder()
                              .name("Employee2")
                              .salary(500.00)
                              .address(ADD_DAO.save(
                                      Address.builder()
                                             .addressLine1("AddLine12")
                                             .addressLine2("AddLine22")
                                             .build()))
                              .build();
        EMP_DAO.save(e1);
        EMP_DAO.save(e2);
        EMP_DAO.save(e3);
        LOGGER.info("Data entry complete");
    }
}
