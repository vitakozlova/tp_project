package bsu.fpmi.tp.util;

import bsu.fpmi.tp.db.EmployeeDao;
import bsu.fpmi.tp.model.Employee;
import bsu.fpmi.tp.model.EmployeeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vlad Abramov
 * @since 18.11.2014
 */
@Service
public class EmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static boolean superAdminSet = false;

    @Override
    public EmployeeDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        if (!superAdminSet) {
            addSuperAdmin();
        }
        Employee employee = employeeDao.getEmployeeByLogin(userLogin);

        if (employee == null) {

            throw new UsernameNotFoundException(userLogin);
        }

        return new EmployeeDetails(employee, getAuthorities(employee.getRole()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(EmployeeRole role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(role.toString()));
        return authList;
    }

    private void addSuperAdmin() {
        String login = "manager";
        if (employeeDao.getEmployeeByLogin(login) == null) {
            employeeDao.addEmployee(new Employee(login, passwordEncoder.encodePassword("manager", login), EmployeeRole.ROLE_MANAGER, "Вита", "Козлова"));
        }
        superAdminSet = true;
    }
}
