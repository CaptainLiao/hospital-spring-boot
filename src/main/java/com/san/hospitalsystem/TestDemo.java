package com.san.hospitalsystem;

import java.util.Date;
import java.util.Random;

public class TestDemo {

  public static void main(String[] args) {
    Long start = new Date("1995/01/01 00:00:00").getTime();
    Long end = new Date("1995/12/31 23:59:59").getTime();
    Random random = new Random();

    System.out.println(random.nextFloat());

    System.out.println("1995 年的第一天" + new Date("1995/01/01 00:00:00"));
    System.out.println("1995 年的最后一天" + new Date("1995/12/31 23:59:59"));
    System.out.println("1995 年的随机一天" + new Date(start + (long) (random.nextFloat() * (end - start))));
  }
}
