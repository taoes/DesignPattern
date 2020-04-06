package com.zhoutao123.design.principle;

public class DIP2 {

  public static void main(String[] args) {
    IDriver tom = new Driver();
    // tom 可以驾驶BWM
    tom.drive(new BWM(), 100);

    // tom 也可以驾驶BenZ
    tom.drive(new BenZ(), 90);
  }

  static class Driver implements IDriver {

    @Override
    public void drive(ICar iCar, int speed) {
      iCar.run(speed);
    }
  }

  static class BenZ implements ICar {

    @Override
    public String name() {
      return "BenZ";
    }

    @Override
    public void run(int speed) {
      System.out.println("奔驰车正在以" + speed + " 速度运行");
    }
  }

  static class BWM implements ICar {

    @Override
    public String name() {
      return "BWM";
    }

    @Override
    public void run(int speed) {
      System.out.println("BWM正在以" + speed + " 速度运行");
    }
  }

  interface ICar {

    /** 汽车的名称 */
    String name();

    /** 汽车运行 */
    void run(int speed);
  }

  interface IDriver {

    /** 驾驶ICar 避免依赖其实现的子类 */
    void drive(ICar car, int speed);
  }
}
