package com.san.hospitalsystem.service.impl;

import com.san.hospitalsystem.Mapper.DepartmentMapper;
import com.san.hospitalsystem.entity.Department;
import com.san.hospitalsystem.entity.Doctor;
import com.san.hospitalsystem.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
  @Autowired
  private DepartmentMapper departmentMapper;

  @Override
  public List<Department> getDepartment(int id) {
    return departmentMapper.getDepartment(id);
  }

  @Override
  public List<Doctor> getDoctorsByDepartmentId(int id) {
    return departmentMapper.getDoctorsByDepartmentId(id);
  }

  @Override
  public Doctor getDoctorById(int id) {
    return departmentMapper.getDoctorById(id);
  }
}
