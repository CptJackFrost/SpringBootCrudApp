package com.springbootcomapp.controller;


import com.springbootcomapp.dao.EmployeeDAO;
import com.springbootcomapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})

    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }

    @RequestMapping(value = "/employee/{empNo}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})

    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        return employeeDAO.getEmployee(empNo);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})

    public Employee addEmployee(@RequestBody Employee emp) {

        if (emp.getEmpNumber() != null) {

            System.out.println("(Service Side) Creating employee: " + emp.getEmpNumber());

            return employeeDAO.addEmployee(emp);
        } else {
            System.out.println("ошибка");
            return emp;
        }
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})


    public Employee updateEmployee(@RequestBody Employee emp) {

        if (emp.getEmpNumber() != null) {

            System.out.println("Editing employee: " + emp.getEmpNumber());

            return employeeDAO.updateEmployee(emp);
        } else {
            System.out.println("ошибка");
            return emp;
        }
    }

    @RequestMapping(value = "/employee/{empNumber}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})


    public void deleteEmployee(@PathVariable("empNumber") String empNumber) {

        System.out.println("Deleting employee: " + empNumber);

        employeeDAO.deleteEmployee(empNumber);
    }

}
