package com.hacatac.Springboot.letsgo.service;

import com.hacatac.Springboot.letsgo.entity.Department;
import com.hacatac.Springboot.letsgo.exceptions.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

  public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public Department updateDepartment(Long departmentId, Department department);

    public void deleteDepartmentById(Long departmentId);

     Department fetchDepartmentByName(String departmentName);
}
