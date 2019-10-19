package com.san.hospitalsystem.service;

import com.san.hospitalsystem.entity.Department;
import com.san.hospitalsystem.entity.Doctor;

import java.util.List;

public interface IDepartmentService {
  List<Department> getDepartment(int id);

  List<Doctor> getDoctorsByDepartmentId(int id);
  Doctor getDoctorById(int id);
}
