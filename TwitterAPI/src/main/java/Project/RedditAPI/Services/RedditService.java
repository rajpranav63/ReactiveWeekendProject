package Project.RedditAPI.Services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static Project.RedditAPI.Services.Auth2.Auth.getAuthToken;

public class RedditService {
    public static Mono<String> readArticles(String subReddit) {
        WebClient webClient = WebClient.builder().build();
        HttpHeaders headers = new HttpHeaders();
        return getAuthToken().flatMap(authToken -> {
            headers.setBearerAuth(authToken);
            headers.put("User-Agent",
                    Collections.singletonList("tomcat:com.e4developer.e4reddit-test:v1.0 (by /u/pranav_raj63)"));
            return webClient.get()
                    .uri("https://oauth.reddit.com/best")
                    .headers(httpHeaders -> httpHeaders.addAll(headers))
                    .retrieve()
                    .bodyToMono(String.class);
        });
    }

    public static Mono<String> postArticle(String subReddit, String title, String content) {
        WebClient webClient = WebClient.builder().build();
        HttpHeaders headers = new HttpHeaders();
        return getAuthToken().flatMap(authToken -> {
            headers.setBearerAuth(authToken);
            headers.put("User-Agent",
                    Collections.singletonList("tomcat:com.e4developer.e4reddit-test:v1.0 (by /u/pranav_raj63)"));
            headers.setContentType(MediaType.APPLICATION_JSON);
            String REDDIT_API_URL = "https://oauth.reddit.com/api/submit";
            MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
            requestBody.add("kind", "self");
            requestBody.add("sr", subReddit);
            requestBody.add("title", title);
            requestBody.add("text", content);
            return webClient.post()
                    .uri(REDDIT_API_URL)
                    .headers(httpHeaders -> httpHeaders.addAll(headers))
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class);
        });
    }
}
