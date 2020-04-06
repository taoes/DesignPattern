package com.zhoutao123.design.principle;

public class LKP3 {

  public static void main(String[] args) {
    Phone phone = new Phone();

    System.out.println("手机是一款好手机吗?" + phone.check());
  }

  static class Phone {

    private boolean isCheap() {
      return false;
    }

    private boolean isGood() {
      return true;
    }

    private boolean isNewVersion() {
      return true;
    }

    public boolean check() {
      return !this.isCheap() && this.isGood() && this.isNewVersion();
    }
  }
}
