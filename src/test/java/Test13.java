import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test11.Rank;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Recordsの例")
public class Test13 {

  record User(String shi, String mei) {
    String fullName() {
      return "%s %s".formatted(shi, mei);
    }
  }

  record UserRank(User user, Rank rank) {
  }

  @Test
  @DisplayName("データの入れ物として使ってみる")
  void case01() {
    User user = new User("Higuma", "Duke");

    String fullname = user.fullName();
    assertThat(fullname).isEqualTo("Higuma Duke");
  }
}
