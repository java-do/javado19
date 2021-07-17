import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Streamの拡張")
public class Test09 {

  @Test
  @DisplayName("Streamの結果をimmutableListで取得する")
  void case01() {
    List<Integer> origList = List.of(2, 3, 4, 5);
    List<Double> powList = origList.stream()
      .map(i -> Math.pow(i, 2))
      .toList();

    assertThat(powList).containsExactly(4d, 9d, 16d, 25d);
  }


}
