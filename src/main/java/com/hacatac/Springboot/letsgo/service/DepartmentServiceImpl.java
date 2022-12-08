package com.hacatac.Springboot.letsgo.service;

import com.hacatac.Springboot.letsgo.entity.Department;
import com.hacatac.Springboot.letsgo.exceptions.DepartmentNotFoundException;
import com.hacatac.Springboot.letsgo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        Department newDepartment = departmentRepository.save(department);
        return newDepartment;
    }

    @Override
    public List<Department> fetchDepartmentList() {
        List<Department> listOfDepartments = departmentRepository.findAll();
        return listOfDepartments;
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return department.get();

    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department fetchedDepartment = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
         !"".equalsIgnoreCase(department.getDepartmentName())) {
            fetchedDepartment.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            fetchedDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            fetchedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        Department newDepartment = departmentRepository.save(fetchedDepartment);

        return newDepartment;

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
