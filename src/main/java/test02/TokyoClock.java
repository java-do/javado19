package test02;

public class TokyoClock implements WorldClock {

  @Override
  public String getZoneCode() {
    return "JST";
  }

  // instance of のデモで使う存在意義の薄い固有メソッド
  public String tokyo() {
    return "東京は日本にあります.";
  }


}
