package test02;

public class TokyoClock implements WorldClock {

  @Override
  public String getZoneCode() {
    return "JST";
  }

}
