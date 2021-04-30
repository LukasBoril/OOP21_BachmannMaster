package ch.zhaw.exercise.le07b.task03;

/**
 * https://newsapi.org/
 * <p>
 * You first need to head to their website and register for an API key.
 * https://newsapi.org/register
 * <p>
 * 6b1fffe09e02470eae49cb3c83b079af
 * <p>
 * https://newsapi.org/docs/get-started
 * <p>
 * For this example add a gson (json mapper) dependency to maven
 * <dependency>
 * <groupId>com.google.code.gson</groupId>
 * <artifactId>gson</artifactId>
 * <version>2.8.5</version>
 * </dependency>
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;


public class NewsScript {

    public static void main(String[] args) {
        System.out.println("### NewsScript! v1.0: Get Daily News ###");
        // String API_KEY = "<your api key here>";
        String API_KEY = "6b1fffe09e02470eae49cb3c83b079af";
        try {
            // JDK 8 Option of an HttpClient
            URL url = new URL(String.format("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=%s", API_KEY));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Read the response from newsapi.org
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine);
            }
            String response = content.toString();
            System.out.println("## response body: " + response);

            // create a gson with a LocalDateTime deserializer for ISO8601 Data e.g. 2020-11-19T19:20:39
            Gson gson = new GsonBuilder().registerTypeAdapter(
                    LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                            ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()
            ).create();
            NewsDTO newsDTO = gson.fromJson(response, NewsDTO.class);

            for (ArticleDTO art : newsDTO.articles) {
                System.out.println("\n### " + art.title + " ### ");
                System.out.println("    (Published at: " + art.publishedAt + ", Author: " + art.author
                        + ", Source: " + art.source.name + ")\n");                System.out.println("Description: " + art.description);

                System.out.println("Read more:   " + art.url + "\n");
                System.out.println("Check image: " + art.urlToImage + "\n");
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class NewsDTO {
    String status;
    int totalResults;
    ArrayList<ArticleDTO> articles;
}

class ArticleDTO {
    SourceDTO source;
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    LocalDateTime publishedAt;
    String content;
}

class SourceDTO {
    String id;
    String name;
}
