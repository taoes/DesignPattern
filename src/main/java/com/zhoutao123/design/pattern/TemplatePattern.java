package com.zhoutao123.design.pattern;

public class TemplatePattern {

  public static void main(String[] args) {
    Task readTask = new ReadTask();
    readTask.runTask();

    Task writeTask = new WriteTask();
    writeTask.runTask();
  }

  //   定义抽象类
  abstract static class Task {
    abstract void start();

    abstract void exec();

    abstract void stop();

    void runTask() {
      start();
      exec();
      stop();
    }
  }

  static class ReadTask extends Task {

    @Override
    void start() {
      System.out.println("开始阅读");
    }

    @Override
    void exec() {
      System.out.println("正在阅读");
    }

    @Override
    void stop() {
      System.out.println("停止阅读");
    }
  }

  static class WriteTask extends Task {

    @Override
    void start() {
      System.out.println("开始写作");
    }

    @Override
    void exec() {
      System.out.println("正在写作");
    }

    @Override
    void stop() {
      System.out.println("结束写作");
    }
  }
}
