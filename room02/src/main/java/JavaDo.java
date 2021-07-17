import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaDo {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(60))
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.covid19api.com/total/country/india"))
                .GET()
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();
            System.out.println(responseBody);
            ObjectMapper mapper = new ObjectMapper();
            Covid jsonObj[] = mapper.readValue(responseBody, Covid[].class);
            System.out.println(jsonObj[0]);

            var dates = Arrays.stream(jsonObj).filter(covid -> covid.Active() > 1_000_000).sorted((a, b) -> b.Active() - a.Active()).toList();
            dates.forEach(c -> System.out.println("[%s] %s people".formatted(c.Date, c.Active)));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    record Covid(String Date, int Confirmed, int Deaths, int Recovered, int Active
    ,String Country, String CountryCode, String Province, String City, String CityCode, int Lat, int Lon){};

}
