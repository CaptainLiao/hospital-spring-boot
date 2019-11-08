package com.san.hospitalsystem.common.init;

import com.san.hospitalsystem.Mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@Component
public class InitDB implements ApplicationRunner {
  @Autowired
  CommonMapper commonMapper;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("InitDB");
    Map count = commonMapper.checkTableExist("user");
    if (CollectionUtils.isEmpty(count)) return;
    System.out.println(count);
  }
}
