package com.zhoutao123.design.pattern;

/**
 * 抽象工厂设计模式
 *
 * @author 周涛
 */
public class AbstractFactoryDesignPatter {

  public static void main(String[] args) {
    //
  }

  abstract class Book {
    abstract String getType();

    abstract String getColor();

    abstract Float getPrice();
  }

  abstract class RedBook extends Book {

    @Override
    String getColor() {
      return "RED";
    }
  }

  abstract class GreenBook extends Book {

    @Override
    String getColor() {
      return "GREEN";
    }
  }

  // 具体书籍实现
  class RedITBook extends RedBook {

    @Override
    String getType() {
      return "IT";
    }

    @Override
    Float getPrice() {
      return 123F;
    }
  }

  class RedStoreBook extends RedBook {

    @Override
    String getType() {
      return "Store";
    }

    @Override
    Float getPrice() {
      return 3243.43F;
    }
  }

  // 蓝色的书籍
  class BlueITBook extends RedBook {

    @Override
    String getType() {
      return "IT";
    }

    @Override
    Float getPrice() {
      return 123F;
    }
  }

  class BlueStoreBook extends RedBook {

    @Override
    String getType() {
      return "Store";
    }

    @Override
    Float getPrice() {
      return 3243.43F;
    }
  }

  interface Factory {

    Book createRedBook();

    Book createBlueBook();
  }

  class ITBookFactory implements Factory {

    @Override
    public Book createRedBook() {
      return new RedITBook();
    }

    @Override
    public Book createBlueBook() {
      return new BlueITBook();
    }
  }

  class StoreBookFactory implements Factory {

    @Override
    public Book createRedBook() {
      return new RedStoreBook();
    }

    @Override
    public Book createBlueBook() {
      return new BlueStoreBook();
    }
  }
}
