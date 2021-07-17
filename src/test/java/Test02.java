import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("テキストファイルを読み書きする")
public class Test02 {

  Path readFilePath;
  Path writeFilePath;

  @BeforeEach
  void setUp() throws URISyntaxException {
    readFilePath = Paths.get(Objects.requireNonNull(getClass().getResource("Read.txt")).toURI());
    writeFilePath = Paths.get(Objects.requireNonNull(getClass().getResource("Write.txt")).toURI());
  }

  @Test
  @DisplayName("テキストファイルの読み込み")
  void case01() throws IOException {
    String s = Files.readString(readFilePath, StandardCharsets.UTF_8);
    assertThat(s).isEqualTo("This is only a test.");
//    fail();
  }

  @Test
  @DisplayName("テキストファイルの書き込み")
  void case02() throws IOException {
    String str = LocalTime.now().toString();
    Files.writeString(writeFilePath, str, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);

    String actual = Files.readString(writeFilePath, StandardCharsets.UTF_8);
    assertThat(actual).isEqualTo(str);
//    fail();
  }

}
