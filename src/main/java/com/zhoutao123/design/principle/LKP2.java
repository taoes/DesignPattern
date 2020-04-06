package com.zhoutao123.design.principle;

import java.util.ArrayList;
import java.util.List;

public class LKP2 {

  public static void main(String[] args) {
    Teacher teacher = new Teacher();
    GroupLeader groupLeader = new GroupLeader();

    teacher.command(groupLeader);
  }

  static class Teacher {
    public void command(GroupLeader leader) {

      int count = leader.count();
      System.out.println("学生有" + count + "个");
    }
  }

  static class GroupLeader {
    private List<Student> stuList;

    public void setStuList() {
      List<Student> list = new ArrayList<>();
      // 调用其他服务查询学生列表
      this.stuList = list;
    }

    public int count() {
      return stuList.size();
    }
  }

  static class Student {
    private String name;
  }
}
