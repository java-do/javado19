import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Optionalの拡張例")
public class Test07 {

  @Test
  @DisplayName("Nullじゃないときのアクション")
  void case01() {
    String message = "値は %s".formatted(print("Duke"));

    assertThat(message).isEqualTo("値は Duke");
//    fail();
  }

  @Test
  @DisplayName("Nullじゃないときのアクション")
  void case02() {
    String message = "値は %s".formatted(print(null));

    assertThat(message).isEqualTo("値は 初期値");
//    fail();
  }

  String print(String str) {
    return Optional.ofNullable(str)
      .or(() -> Optional.of("初期値"))
      .get();
  }
  
}
