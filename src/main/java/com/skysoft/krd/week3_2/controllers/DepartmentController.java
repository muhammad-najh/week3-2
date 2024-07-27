package com.skysoft.krd.week3_2.controllers;

import com.skysoft.krd.week3_2.entities.DepartmentEntity;
import com.skysoft.krd.week3_2.entities.EmployeeEntity;
import com.skysoft.krd.week3_2.repositories.DepartmentRepository;
import com.skysoft.krd.week3_2.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService, DepartmentRepository departmentRepository) {

        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.createNewDepartment(departmentEntity);
    }
    @PutMapping(path = "/department/{departmentId}/employee/{employeeId}")
    public DepartmentEntity assignEmployeeToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignEmployeeToDepartment(departmentId,employeeId);

    }
    @GetMapping(path = "/assignedDepartmentOfManager/{employeeId}")
    private DepartmentEntity getAssignedDepartmentOfManager( @PathVariable Long employeeId) {
        return departmentService.getAssignedDepartmentOfManager(employeeId);
    }

    @GetMapping(path = "managedDepartment/{employeeid}")
    private DepartmentEntity getManagedDepartmentOfManager(@PathVariable Long employeeid) {
        return departmentService.getDepartmentMangedBy(employeeid);
    }
    @PutMapping("{departmentId}/worker/{employeeId}")
    private DepartmentEntity assignedWorkerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignedWorkerToDepartment(departmentId,employeeId);
    }

    @PutMapping("{departmentId}/freelancer/{employeeId}")
    private DepartmentEntity assignFreelancerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return  departmentService.assignFreelancerToDepartment(departmentId,employeeId);
    }


}
