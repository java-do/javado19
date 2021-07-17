import org.junit.jupiter.api.Test;
import test11.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class Test13 {
  
  record User(String shi, String mei) {
    String fullName() {
      return "%s %s".formatted(shi, mei);
    }
  }

  record UserRank(User user, Rank rank) {
  }

  @Test
  void case01() {

    User user = new User("Higuma", "Duke");

    String fullname = user.fullName();
    assertThat(fullname).isEqualTo("Higuma Duke");
  }
}
