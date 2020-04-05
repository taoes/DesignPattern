package com.zhoutao123.design.pattern;


/**
 * 单例设计模式
 *
 * @author zhoutao
 */
public class SingletonDesignPattern {

  public static void main(String[] args) {

    // 懒汉式 LazyLoadingModel
    LazyLoadSingleton instance = LazyLoadSingleton.getInstance();
    assert instance != null;

    // 饿汉式 HangerLoadingModel
    HangerSingleton hangerSingleton = HangerSingleton.getInstance();
    assert hangerSingleton != null;

    // DCL 设计模式

  }


  /**
   * 单例之懒汉式
   */
  static class LazyLoadSingleton {

    private static LazyLoadSingleton instance;

    public static synchronized LazyLoadSingleton getInstance() {
      if (instance == null) {
        instance = new LazyLoadSingleton();
      }
      return instance;
    }
  }


  /**
   * 单例值饿汉式
   */
  static class HangerSingleton {

    private static HangerSingleton instance = new HangerSingleton();

    public static synchronized HangerSingleton getInstance() {
      return instance;
    }
  }

  static class DclSingleton{
    private static DclSingleton instance;

    public static  synchronized DclSingleton getInstance(){
      if (instance == null){
        synchronized (DclSingleton.class){
          if (instance == null){
            instance = new DclSingleton();
          }
        }
      }
      return instance;
    }
  }
}
