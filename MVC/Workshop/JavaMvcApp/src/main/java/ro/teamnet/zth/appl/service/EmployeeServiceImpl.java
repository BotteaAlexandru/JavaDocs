package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employee = new EmployeeDao();

    @Override
    public List<Employee> findAllEmployees() {

        return employee.getAllEmployees();
    }

    @Override
    public Employee findOneEmployee(Long id) {
        return employee.getEmployeeById(id);
    }

    @Override
    public void deleteOneEmployee(Long id) {
        employee.deleteEmployee(employee.getEmployeeById(id));
    }
}
