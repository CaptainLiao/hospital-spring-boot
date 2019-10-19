package com.san.hospitalsystem.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Doctor implements Serializable {
  private int id;
  private String name;
  private String intro;
  private String title;

  private String departmentName;
  private String departmentDesc;
  private String catName;
}
