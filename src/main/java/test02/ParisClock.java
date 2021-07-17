package test02;

public class ParisClock implements WorldClock {

  @Override
  public String getZoneCode() {
    return "ECT";
  }

  // instance of のデモで使う存在意義の薄い固有メソッド
  public String paris() {
    return "パリはフランスにあります.";
  }
}
