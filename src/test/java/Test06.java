import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@DisplayName("Collectionの拡張例")
public class Test06 {

  @Test
  @DisplayName("of メソッドでイミュータブルなList, Set, Mapなどを作れる")
  void case01() {
    List<String> alphabetList = List.of("a", "b", "c");
    // イミュータブルなリストなので、要素は変更できない
    // alphabetList.add("z");

    Set<String> alphabetSet = Set.of("d", "e", "f");
    // 同上
    // alphabetSet.add("z");　

    Map<String, String> alphabetMap =
      Map.of("g", "ジー", "h", "エイチ", "i", "アイ");
    // 同上
    //  alphabetMap.put("z", "ゼット");

    assertThat(alphabetList).contains("a", "b", "c");
    assertThat(alphabetSet).contains("d", "e", "f");
    assertThat(alphabetMap).contains(entry("g", "ジー"), entry("h", "エイチ"), entry("i", "アイ"));
  }

  @Test
  @DisplayName("copyOf メソッドでイミュータブルなList, Set, Mapなどを複写できる")
  void case02() {
    List<String> mutable = new ArrayList<>();
    mutable.add("a");
    mutable.add("b");
    mutable.add("c");

    List<String> imutableCopy = List.copyOf(mutable);
    // イミュータブルなリストなので、要素は変更できない
    // imutableList.add("z");
    assertThat(imutableCopy).containsExactly("a", "b", "c");
  }
}
