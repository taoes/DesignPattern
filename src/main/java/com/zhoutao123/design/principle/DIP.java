package com.zhoutao123.design.principle;

public class DIP {

  public static void main(String[] args) {
    Driver tom = new Driver();
    tom.driver(new BenZ());
  }

  static class Driver {
    public void driver(BenZ benZ) {
      benZ.run(100);
    }
  }

  static class BenZ {
    public void run(int speed) {
      System.out.println("奔驰车正在以" + speed + " 速度运行");
    }
  }

  static class BWM {
    public void run(int speed) {
      System.out.println("BWM正在以" + speed + " 速度运行");
    }
  }
}
