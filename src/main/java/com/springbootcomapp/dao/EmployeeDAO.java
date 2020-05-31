package com.springbootcomapp.dao;

import com.springbootcomapp.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAO {
    private static final Map<String, Employee> empMap = new HashMap<String, Employee>();

    static {
        initEmp();
    }

    public static void initEmp() {
        Employee emp1 = new Employee("E01", "Smith", "Salesman");
        Employee emp2 = new Employee("E02", "Jones", "Manager");
        Employee emp3 = new Employee("E03", "Black", "Worker");

        empMap.put(emp1.getEmpNumber(), emp1);
        empMap.put(emp2.getEmpNumber(), emp2);
        empMap.put(emp3.getEmpNumber(), emp3);
    }

    public Employee getEmployee(String empNumber) {
        return empMap.get(empNumber);
    }

    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getEmpNumber(), emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        empMap.put(emp.getEmpNumber(), emp);
        return emp;
    }

    public void deleteEmployee(String empNumber) {
        empMap.remove(empNumber);
    }

    public List<Employee> getAllEmployees() {
        Collection<Employee> col = empMap.values();
        List<Employee> empList = new ArrayList<Employee>();
        empList.addAll(col);
        return empList;
    }
}
