package test02;

public class ParisClock implements WorldClock {

  @Override
  public String getZoneCode() {
    return "ECT";
  }

}
