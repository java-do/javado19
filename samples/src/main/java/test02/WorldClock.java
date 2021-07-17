package test02;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface WorldClock {

  // 実装クラスが実装するメソッド
  String getZoneCode();

  // 実装クラスが共通して持つ（デフォルト処理の）メソッド
  default ZonedDateTime getZonedTime() {
    return ZonedDateTime.of(LocalDateTime.now(), makeZoneId(getZoneCode()));
  }

  // defaultメソッドから処理を分離できるprivateメソッド
  private ZoneId makeZoneId(String zoneCode) {
    return ZoneId.of(zoneCode, ZoneId.SHORT_IDS);
  }

}
