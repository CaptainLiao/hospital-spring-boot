package com.san.hospitalsystem.controller;

import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.Department;
import com.san.hospitalsystem.entity.Doctor;
import com.san.hospitalsystem.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

  @Autowired
  private IDepartmentService departmentService;

  @RequestMapping(value = "/getDepartmentById", method = RequestMethod.GET)
  public ServerResponse<List<Department>> getDepartmentById(@RequestParam(value = "id", defaultValue = "0") int id) {
    List<Department> list = departmentService.getDepartment(id);
    return ServerResponse.createBySuccess(list);
  }

  @RequestMapping(value = "/getDoctorsByDepartmentId", method = RequestMethod.GET)
  public ServerResponse<List<Doctor>> getDoctorsByDepartmentId(int id) {
    List<Doctor> list = departmentService.getDoctorsByDepartmentId(id);
    return ServerResponse.createBySuccess(list);
  }

  @RequestMapping(value = "/getDoctorById", method = RequestMethod.GET)
  public ServerResponse<Doctor> getDoctorById(int id) {
    Doctor doctor = departmentService.getDoctorById(id);
    return ServerResponse.createBySuccess(doctor);
  }
}
