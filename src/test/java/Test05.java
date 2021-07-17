import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HTTPClient")
public class Test05 {

  @Test
  @DisplayName("首相官邸のHTMLを文字列で取得する")
  void case01() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newBuilder()
      .version(Version.HTTP_1_1)
      .followRedirects(Redirect.NORMAL)
      .connectTimeout(Duration.ofSeconds(20))
      .build();

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://www.kantei.go.jp"))
      .GET()
      .build();

    // 本来は例外処理が必要
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    assertThat(response.body()).contains("首相官邸のホームページです。");
//    fail();
  }
}
