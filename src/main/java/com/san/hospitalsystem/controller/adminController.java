package com.san.hospitalsystem.controller;

import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.Doctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class adminController {

  @PostMapping(value = "/doctor/add")
  public ServerResponse<Doctor> addDoctor(Doctor doctor) {
    return ServerResponse.createBySuccess("创建成功", doctor);
  }

  @PostMapping(value = "/doctor/delete")
  public ServerResponse<Integer> deleteDoctor(int doctorId) {
    return ServerResponse.createBySuccess("删除成功", doctorId);
  }
}
