package com.san.hospitalsystem.Mapper;

import com.san.hospitalsystem.entity.Department;
import com.san.hospitalsystem.entity.Doctor;

import java.util.List;


public interface DepartmentMapper {
  List<Department> getDepartment(int id);

  List<Doctor> getDoctorsByDepartmentId(int id);
  Doctor getDoctorById(int id);
}
