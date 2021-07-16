import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("try-with-resources x 実質finalな変数")
public class Test01 {

  InputStream in;

  @BeforeEach
  void beforeEach() throws IOException {
    in = Objects.requireNonNull(getClass().getResource("Read.txt")).openStream();
  }

  @Test
  @DisplayName("明示的にcloseしていない")
  void case01() {
    // close しないといけないリソースの取得
    Scanner scanner = new Scanner(in);

    System.out.printf("hasNext: %s%n", scanner.hasNext());

    String actual = scanner.toString();
    // close していないので、Scanner(とInputStream）がOpenのまま
    assertThat(actual).contains("source closed=false");
    // fail();
  }

  @Test
  @DisplayName("実質的finalな変数をtry-with-resourcesでcloseできる")
  void case02() {
    // close しないといけないリソースの取得
    Scanner scanner = new Scanner(in);

    // 実質的final
    try (scanner) {
      System.out.printf("hasNext: %s%n", scanner.hasNext());
    }

    String actual = scanner.toString();
    // try-with-resouces で、Scanner(とInputStream）がcloseされる
    assertThat(actual).contains("source closed=true");
    // fail();
  }

}