package se.jensen.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.jensen.entity.Employee;
import se.jensen.dao.EmployeeDao;
import se.jensen.dao.EmployeeFakeDao;

import java.util.logging.Logger;

public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getSimpleName());
    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployeeById(Integer employeeId) {
        return employeeDao.getEmployee(employeeId);
    }
    public Employee createOrUpdateEmployee(Employee employee) {
        return employeeDao.updateOrCreate(employee);
    }
}
