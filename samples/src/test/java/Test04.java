import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("ローカル変数をvarで定義する")
public class Test04 {


  @Test
  @DisplayName("ローカル変数をvarで定義する例1")
  void case01() {
    var greeting = "Hello, Higuma Duke!";

    assertThat(greeting.length()).isEqualTo(19);
//    fail();
  }

  @Test
  @DisplayName("ローカル変数をvarで定義する例2")
  void case02() {
    var actual = new Random().nextInt(10);

    assertThat(actual).isBetween(0, 9);
//    fail();
  }

  @Test
  @DisplayName("ローカル変数をvarで定義する例3")
  void case03() {
    var actual = new ArrayList<String>();
    actual.add("a");
    actual.add("b");
    actual.add("c");

    assertThat(actual).contains("a", "b", "c");
//    fail();
  }

}
