package com.skysoft.krd.week3_2.services;


import com.skysoft.krd.week3_2.entities.DepartmentEntity;
import com.skysoft.krd.week3_2.entities.EmployeeEntity;
import com.skysoft.krd.week3_2.repositories.DepartmentRepository;
import com.skysoft.krd.week3_2.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id) {

        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeeEntity getDepartmentManger(Long departmentID) {

        DepartmentEntity departmentEntity=departmentRepository.findById(departmentID).orElse(null);
        return employeeRepository.findByManagedDepartment(departmentEntity);
    }
}
