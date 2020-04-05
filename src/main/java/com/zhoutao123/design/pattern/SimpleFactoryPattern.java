package com.zhoutao123.design.pattern;

import java.util.Objects;

/**
 * 简单工厂模式
 */
public class SimpleFactoryPattern {

  public static void main(String[] args) {
    Phone apple = PhoneFactory.getPhone("APPLE");
    apple.call("1xx");

    Phone xiaomi = PhoneFactory.getPhone("XIAOMI");
    xiaomi.sendMessage("1xx", "MESSAGE");
  }

  interface Phone {

    String getModel();

    void call(String phone);

    void sendMessage(String phone, String context);
  }

  static class PhoneFactory {

    public static Phone getPhone(String model) {
      if (Objects.equals(model, "APPLE")) {
        return new IPhoneX();
      } else if (Objects.equals(model, "XIAOMI")) {
        return new Mi6();
      } else {
        throw new RuntimeException("NOT SUPPORT MODEL");
      }
    }
  }

  static class IPhoneX implements Phone {

    private String model;

    private Float price;

    @Override
    public String getModel() {
      return "APPLE";
    }

    @Override
    public void call(String phone) {
      System.out.println("IPhoneX.call");
    }

    @Override
    public void sendMessage(String phone, String context) {
      System.out.println("IPhoneX.sendMessage");
    }
  }

  static class Mi6 implements Phone {

    private String model;

    private Float price;

    @Override
    public String getModel() {
      return "XIAOMI";
    }

    @Override
    public void call(String phone) {
      System.out.println("Mi6.call");
    }

    @Override
    public void sendMessage(String phone, String context) {
      System.out.println("Mi6.sendMessage");
    }
  }
}
