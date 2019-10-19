package com.san.hospitalsystem.entity;

import java.util.List;
import java.util.Objects;

public class Department {
  private int id;
  private int parentId;
  private String catName;
  private List<Department> subDepartments;

  public int getId() {
    return id;
  }

  public List<Department> getSubDepartments() {
    return subDepartments;
  }

  public void setSubDepartments(List<Department> subDepartments) {
    this.subDepartments = subDepartments;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Department that = (Department) o;
    return id == that.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parentId, catName);
  }
}
