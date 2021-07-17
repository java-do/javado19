import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test02.ParisClock;
import test02.TokyoClock;
import test02.WorldClock;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Instance of のパターンマッチ")
public class Test10 {

  @Test
  @DisplayName("instance of の実装クラスの固有メソッドを実行する1")
  void case01() {
    WorldClock clock = new TokyoClock();
    String actual = checkZone(clock);
    assertThat(actual).isEqualTo("東京は日本にあります.");
  }

  @Test
  @DisplayName("instance of の実装クラスの固有メソッドを実行する1")
  void case02() {
    WorldClock clock = new ParisClock();
    String actual = checkZone(clock);
    assertThat(actual).isEqualTo("パリはフランスにあります.");
  }

  private String checkZone(WorldClock clock) {
    if (clock instanceof TokyoClock tkc) {
      return tkc.tokyo();
    }
    if (clock instanceof ParisClock prc) {
      return prc.paris();
    }
    return "";
  }


  private String oldCheckZone(WorldClock clock) {
    if (clock instanceof TokyoClock) {
      TokyoClock tkc = (TokyoClock) clock;
      return tkc.tokyo();
    }
    if (clock instanceof ParisClock) {
      ParisClock prc = (ParisClock) clock;
      return prc.paris();
    }
    return "";
  }
}
