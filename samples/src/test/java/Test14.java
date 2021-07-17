import org.junit.jupiter.api.Test;
import test14.Button;
import test14.OKButton;

import static org.assertj.core.api.Assertions.assertThat;

public class Test14 {

  @Test
  void case01() {
    Button ok = new OKButton();
    String actual = ok.onPush();

    assertThat(actual).isEqualTo("OKボタンが押ささった");
  }
}
