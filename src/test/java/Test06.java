import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Stringの拡張")
public class Test06 {

  @Test
  @DisplayName("たとえば、Srtring Format")
  void case01() {
    String greeting = "Hello, %s %s !".formatted("Higuma", "Duke");

    assertThat(greeting).isEqualTo("Hello, Higuma Duke !");
//    fail();
  }

  @Test
  @DisplayName("たとえば、Srtring transform")
  void case02() {
    String message = "Hello, Higuma Duke !";
    String digest = message.transform(s -> digest(s));

    assertThat(digest).isEqualTo("Hello...");
//    fail();
  }

  private String digest(String str) {
    if (str.length() > 5) {
      return str.substring(0, 5) + "...";
    }
    return str;
  }


}
