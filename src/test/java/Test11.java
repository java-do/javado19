import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Switch式")
public class Test11 {

  @Test
  @DisplayName("ランクAの時はポイントを4倍する")
  void case01() {
    int point = getPoint(Rank.A, 1);
    assertThat(point).isEqualTo(4);
  }

  @Test
  @DisplayName("Switch式でランクが不明なときは0ポイントにする")
  void case02() {
    int point = getPoint(Rank.UNKNOWN, 2);
    assertThat(point).isEqualTo(0);
  }

  private int getPoint(Rank rank, int point) {
    return switch (rank) {
      case A -> point * 4;
      case B -> point * 3;
      case C -> point * 2;
      case D -> point;
      default -> {
        System.out.println("ランクが不明");
        yield 0;
      }
    };
  }
}
