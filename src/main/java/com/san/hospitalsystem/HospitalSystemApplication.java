package com.san.hospitalsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.san.hospitalsystem.Mapper")
public class HospitalSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(HospitalSystemApplication.class, args);
  }

}
