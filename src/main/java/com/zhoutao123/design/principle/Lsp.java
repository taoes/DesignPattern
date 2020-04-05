package com.zhoutao123.design.principle;

public class Lsp {
  public static void main(String[] args) {
    Player player = new Player();
    player.setName("张三");

    // 为玩家配备机枪
    player.setGun(new MachineGun());
    player.killEnemy();

    // 模拟玩家切换手枪
    player.setGun(new HandGun());
    player.killEnemy();
  }

  /** 玩家类 */
  static class Player {

    private String name;

    private AbstractGun gun;

    public void setGun(AbstractGun gun) {
      this.gun = gun;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void killEnemy() {
      if (gun == null) {
        System.out.println("尚未选择武器");
        return;
      }
      gun.shoot();
      System.out.println("玩家使用:【" + this.gun.name() + "】杀死一名敌人");
    }
  }

  /** 抽象的武器类 */
  abstract static class AbstractGun {

    /** 射击方法 */
    abstract void shoot();

    abstract String name();
  }

  /** 手枪的实现 */
  static class HandGun extends AbstractGun {

    @Override
    void shoot() {
      System.out.println("玩家使用手枪射击");
    }

    @Override
    String name() {
      return "手枪";
    }
  }

  /** 机枪的实现 */
  static class MachineGun extends AbstractGun {

    @Override
    void shoot() {
      System.out.println("玩家使用机枪射击");
    }

    @Override
    String name() {
      return "机枪";
    }
  }

  static class ToyGun extends AbstractGun {

    @Override
    void shoot() {
      throw new RuntimeException("玩具手枪不能射击");
    }

    @Override
    String name() {
      return "玩具手枪";
    }
  }
}
