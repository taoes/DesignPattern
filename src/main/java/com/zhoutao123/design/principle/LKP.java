package com.zhoutao123.design.principle;

import java.util.ArrayList;
import java.util.List;

public class LKP {

  public static void main(String[] args) {
    Teacher teacher = new Teacher();
    teacher.command(new GroupLeader());
  }

  static class Teacher {
    public void command(GroupLeader leader) {
      List<Student> stuList = new ArrayList<>();
      // 增加学生
      int count = leader.count(stuList);
      System.out.println("学生有" + count + "个");
    }
  }

  static class GroupLeader {
    public int count(List<Student> stuList) {
      return stuList.size();
    }
  }

  static class Student {
    private String name;
  }
}
