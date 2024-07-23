package com.skysoft.krd.week3_2.services;

import com.skysoft.krd.week3_2.entities.DepartmentEntity;
import com.skysoft.krd.week3_2.entities.EmployeeEntity;
import com.skysoft.krd.week3_2.repositories.DepartmentRepository;
import com.skysoft.krd.week3_2.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id) {

        return departmentRepository.findById(id).orElse(null);
    }






}








