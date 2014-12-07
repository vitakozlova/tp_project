package bsu.fpmi.tp.model;

import bsu.fpmi.tp.util.TPLabContract;

import javax.persistence.*;

/**
 * @author Vlad Abramov
 * @since 18.11.2014
 */
@Entity
@Table(name = TPLabContract.DB.Employee.TABLE_NAME)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = TPLabContract.DB.Employee.ID)
    private Integer id;

    @Column(name = TPLabContract.DB.Employee.LOGIN, nullable = false, unique = true)
    private String login;

    @Column(name = TPLabContract.DB.Employee.PASSWORD_HASH, nullable = false)
    private String passwordHash;

    @Column(name = TPLabContract.DB.Employee.EMPLOYEE_ROLE, nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeRole role = EmployeeRole.ROLE_ADMIN;

    @Column(name = TPLabContract.DB.Employee.FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = TPLabContract.DB.Employee.LAST_NAME, nullable = false)
    private String lastName;

    public Employee() {
    }

    public Employee(String login, String passwordHash, EmployeeRole role, String firstName, String lastName) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String email) {
        this.login = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    @Override
    public String toString() {
        return "{"
                + id + ","
                + login + ","
                + passwordHash + ","
                + role + ","
                + firstName + ","
                + lastName
                + "}";
    }

    @Override
    public boolean equals(Object userObj) {
        if (this == userObj) {
            return true;
        } else if (userObj == null) {
            return false;
        } else if (userObj instanceof Employee) {
            Employee user = (Employee) userObj;

            return id.equals(user.id);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
