import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TextBlocks")
public class Test12 {

  @Test
  void case01() {
    String html = """
      <html>
        <head></head>
        <body></body>
      </html>
      """;

    System.out.println(html);

    int lineNumber = html.split("\r\n|\r|\n").length;
    assertThat(lineNumber).isEqualTo(4);
  }

  @Test
  void case02() {
    String html = """
      <html>
        <body>
        <div>%s</div>
        </body>
      </html>
      """;
    String actual = html.formatted("Hello, Higuma Duke!");

    System.out.println(actual);

    assertThat(actual).contains("Hello, Higuma Duke!");
  }


}
