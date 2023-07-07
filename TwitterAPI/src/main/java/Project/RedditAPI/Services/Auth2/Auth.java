package Project.RedditAPI.Services.Auth2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Auth {
    public static Mono<String> getAuthToken() {
        WebClient webClient = WebClient.builder().build();
        HttpHeaders headers = new HttpHeaders();
        // Different login details as I had to re-create the app
        headers.setBasicAuth("5ZP5WPOVWBz9lPO9koPrtg", "_8P1yo1yll-KswVA5XYVkbGoZKChcw");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.put("User-Agent",
                Collections.singletonList("tomcat:com.e4developer.e4reddit-test:v1.0 (by /u/pranav_raj63)"));
        String body = "grant_type=password&username=pranav_raj63&password=pranav@1234";
        return webClient.post()
                .uri("https://www.reddit.com/api/v1/access_token")
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    ObjectMapper mapper = new ObjectMapper();
                    Map<String, Object> map = new HashMap<>();
                    try {
                        map.putAll(mapper.readValue(response, new TypeReference<Map<String, Object>>() {
                        }));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return String.valueOf(map.get("access_token"));
                });
    }
}



