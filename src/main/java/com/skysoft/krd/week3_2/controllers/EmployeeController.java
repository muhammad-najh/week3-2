package com.skysoft.krd.week3_2.controllers;

import com.skysoft.krd.week3_2.entities.EmployeeEntity;
import com.skysoft.krd.week3_2.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createNewEmployee(employeeEntity);
    }
    @GetMapping(path = "/{employeeid}")
    public EmployeeEntity getEmployeeByID(@PathVariable("employeeid") Long employeeID) {
        return employeeService.getEmployeeById(employeeID);
    }
    @GetMapping(path = "/manger/{departmentid}")
    public EmployeeEntity getDepartmentManger(@PathVariable("departmentid") Long departmentID) {
        return employeeService.getDepartmentManger(departmentID);

    }
}
