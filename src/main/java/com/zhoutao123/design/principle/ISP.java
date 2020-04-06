package com.zhoutao123.design.principle;

public class ISP {

  public static void main() {

    // 仅需要获取用户性别，最小依赖 PersonSexService
    PersonSexService sexService = new PersonInfoServiceImpl();
    boolean isMan1 = sexService.isMan(1);

    // 需要获取其他信息，需要依赖 PersonInfoService
    PersonInfoService infoService = new PersonInfoServiceImpl();
    boolean isMan2 = infoService.isMan(1);
    int personAge = infoService.getPersonAge(1);
    String personName = infoService.getPersonName(1);
  }

  public interface PersonInfoService extends PersonSexService {
    String getPersonName(int personId);

    int getPersonAge(int personId);
  }

  public interface PersonSexService {
    boolean isMan(int personId);
  }

  private static class PersonInfoServiceImpl implements PersonInfoService {

    @Override
    public String getPersonName(int personId) {
      return "NULL";
    }

    @Override
    public int getPersonAge(int personId) {
      return 12;
    }

    @Override
    public boolean isMan(int personId) {
      return true;
    }
  }
}
