package com.zhoutao123.design.pattern;

import java.awt.Color;

/** 简单工厂模式 */
public class SimpleFactoryPattern2 {

  public static void main(String[] args) {
    // 单例模式获取Factory的实例
    Factory factory = ConcreteFactor.getFactory();

    // 符合迪米特法则，上层代码不需要直接连接底层代码
    Book book = factory.getInstance(RedBook.class);
    printBookInfo(book);
    book = factory.getInstance(GreenBook.class.getName());
    printBookInfo(book);
  }

  // 里式替换原则
  private static void printBookInfo(Book book) {
    assert book != null;
    System.out.println("书的价格是:" + book.getPrice() + "颜色是:" + book.getColor());
  }

  //  定义创建者
  interface Factory {
    Book getInstance(String className);

    Book getInstance(Class<? extends Book> clazz);
  }

  static class ConcreteFactor implements Factory {

    private ConcreteFactor() {}

    private static Factory factory = new ConcreteFactor();

    // 使用单例模式，全局唯一工厂对象
    public static Factory getFactory() {
      return factory;
    }

    @Override
    public Book getInstance(String className) {
      try {
        return (Book) Class.forName(className).newInstance();
      } catch (Exception e) {
        return null;
      }
    }

    @Override
    public Book getInstance(Class<? extends Book> clazz) {
      try {
        return clazz.newInstance();
      } catch (Exception e) {
        return null;
      }
    }
  }

  // 定义产品
  abstract static class Book {

    // 描述
    public void desc() {
      System.out.println("这是一本书");
    }

    // 获取书籍的颜色
    public abstract Color getColor();

    // 获取书籍的价格
    public abstract float getPrice();
  }

  static class GreenBook extends Book {

    @Override
    public Color getColor() {
      return Color.GREEN;
    }

    @Override
    public float getPrice() {
      return 123;
    }
  }

  static class RedBook extends Book {

    @Override
    public Color getColor() {
      return Color.RED;
    }

    @Override
    public float getPrice() {
      return 124;
    }
  }
}
