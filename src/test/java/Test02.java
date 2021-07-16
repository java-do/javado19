import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test02.ParisClock;
import test02.TokyoClock;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("インターフェースの default, private メソッド")
public class Test02 {

  @Test
  @DisplayName("パリ時間が表示される")
  void case01() {
    ZonedDateTime parisTime = new ParisClock().getZonedTime();
    assertThat(parisTime.toString()).contains("+02:00");
//    fail();
  }

  @Test
  @DisplayName("日本時間が表示される")
  void case02() {
    ZonedDateTime tokyoTime = new TokyoClock().getZonedTime();
    assertThat(tokyoTime.toString()).contains("+09:00");
//    fail();
  }

}
