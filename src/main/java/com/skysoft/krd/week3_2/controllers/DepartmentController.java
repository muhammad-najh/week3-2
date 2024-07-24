package com.skysoft.krd.week3_2.controllers;

import com.skysoft.krd.week3_2.entities.DepartmentEntity;
import com.skysoft.krd.week3_2.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {

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


}
