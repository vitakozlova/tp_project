package bsu.fpmi.tp.util;

import bsu.fpmi.tp.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author Vlad Abramov
 * @since 18.11.2014
 */
public class EmployeeDetails extends User {

    private Employee employee;

    public EmployeeDetails(Employee employee, Collection<? extends GrantedAuthority> authorities) {
        super(employee.getLogin(), employee.getPasswordHash(), true, true, true, true, authorities);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
