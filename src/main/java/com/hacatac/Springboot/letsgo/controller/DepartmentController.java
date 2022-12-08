package com.hacatac.Springboot.letsgo.controller;

import com.hacatac.Springboot.letsgo.entity.Department;
import com.hacatac.Springboot.letsgo.exceptions.DepartmentNotFoundException;
import com.hacatac.Springboot.letsgo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
            LOGGER.info("Inside saveDepartment of DepartmentController");
            return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department
                                       ) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentByid(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully Deleted Dept";
    }

    @GetMapping("/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
