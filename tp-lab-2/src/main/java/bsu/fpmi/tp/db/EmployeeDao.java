package bsu.fpmi.tp.db;

import bsu.fpmi.tp.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Insert new {@code User} to DB. There is no checking for ensures that {@code newUser} is exactly stored in DB.
     *
     * @param employee user that you want ot store in DB.
     */
    @Transactional
    public void addEmployee(Employee employee) {
        getSession().save(employee);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        getSession().saveOrUpdate(employee);
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer id) {
        return (Employee) getSession().get(Employee.class, id);
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeByLogin(String login) {
        Query query = getSession().createQuery("from Employee user where user.login = :login");
        query.setParameter("login", login);

        @SuppressWarnings("rawtypes")
        List resultList = query.list();

        return (resultList.isEmpty()) ? null : (Employee) resultList.get(0);
    }

    /**
     * Removes {@code User} from DB by identifier.
     *
     * @param id user identifier.
     */
    @Transactional
    public void removeEmployeeById(Integer id) {
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            getSession().delete(employee);
        }
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        Query query = getSession().createQuery("from Employee");
        return (List<Employee>) query.list();
    }

    @Transactional
    public void removeEmployeeByLogin(String login) {
        Employee employee = getEmployeeByLogin(login);

        if (employee != null) {
            getSession().delete(employee);
        }
    }

    @Transactional
    public void removeEmployee(Employee employee) {
        if (employee != null) {
            getSession().delete(employee);
        }
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}