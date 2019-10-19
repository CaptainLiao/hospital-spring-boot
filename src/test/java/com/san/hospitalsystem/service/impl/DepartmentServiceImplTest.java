package com.san.hospitalsystem.service.impl;

import com.san.hospitalsystem.entity.Department;
import com.san.hospitalsystem.entity.Doctor;
import com.san.hospitalsystem.service.IDepartmentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.util.List;


@SpringBootTest
class DepartmentServiceImplTest {
  @Autowired
  private IDepartmentService departmentService;

  @Test
  void getDepartment() {
    List<Department> list = departmentService.getDepartment(0);

    int total = __walk(list);

    Assert.assertEquals(10, total);
  }

  private int __walk(List<Department> departments) {
    int count = departments.size();
    if (count == 0) return count;

    for (Department department : departments) {
      count += __walk(department.getSubDepartments());
    }
    return count;
  }

  @Test
  void getDoctorsByDepartmentId() {
    List<Doctor> doctors = departmentService.getDoctorsByDepartmentId(13);
    // 外科有两个医生
    Assert.assertEquals(2, doctors.size());
  }

  @Test
  void getDoctorById() {
    Doctor doctor = departmentService.getDoctorById(1);
    Assert.assertEquals("张三", doctor.getName());
  }
}