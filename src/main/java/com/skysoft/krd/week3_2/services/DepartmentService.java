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
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, EmployeeRepository employeeRepository1) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository1;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id) {

        return departmentRepository.findById(id).orElse(null);
    }


    public DepartmentEntity assignEmployeeToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        return departmentEntity.flatMap(departmentEntity1 ->
           employeeEntity.map(employeeEntity1 -> {
               departmentEntity1.setManager(employeeEntity1);
               return departmentRepository.save(departmentEntity1);
           })).orElse(null);

    }
    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {

//            Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
//           return employeeEntity.map(employee -> employee.getManagedDepartment()).orElse(null); //first way in both way we need employee entity

        EmployeeEntity employeeEntity = EmployeeEntity.builder().id(employeeId).build();
        return departmentRepository.findByManager(employeeEntity);
    }

    public DepartmentEntity getDepartmentMangedBy(Long employeeId) {
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).orElse(null);
        return departmentRepository.findByManager(employeeEntity);
    }


    ;










}








