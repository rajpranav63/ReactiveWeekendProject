package Project.RedditAPI.controller;

import Project.RedditAPI.Dao.DaoPostData;
import Project.RedditAPI.Dao.DaoReddit;
import Project.RedditAPI.Search.SearchDatabase;
import Project.RedditAPI.Services.RedditService;
import Project.RedditAPI.entity.PostData;
import Project.RedditAPI.entity.RedditData;
import Project.RedditAPI.entity.RedditPostRequest;
import Project.RedditAPI.entity.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.UUID;

import static Project.RedditAPI.Services.RedditService.postArticle;


@RestController
public class RedditController {
    private final DaoReddit daoReddit;
    private final DaoPostData daoPostData;
    private final SearchDatabase searchDatabase;
    private final RedditService reddit = new RedditService();


    @Autowired
    public RedditController(DaoReddit daoReddit, DaoPostData daoPostData, SearchDatabase searchDatabase) {
        this.daoReddit = daoReddit;
        this.daoPostData = daoPostData;
        this.searchDatabase = searchDatabase;
    }

    @PostMapping("/post")
    public Mono<String> postOnReddit(@RequestBody RedditPostRequest request) {
//        System.out.println("Triggered post request");
        String subReddit = request.getSubReddit();
        String title = request.getTitle();
        String content = request.getContent();

        return postArticle(subReddit, title, content)
                .flatMap(response -> {
                    PostData postData = new PostData(UUID.randomUUID().toString(), subReddit, title, content);
                    return daoPostData.save(postData)
                            .thenReturn("Post submitted and stored in the database successfully!");
                });
    }


    @GetMapping("/search/{author}")
    public Flux<RedditData> getSortedPosts(@PathVariable(value = "author", required = true) String author) {
        return searchDatabase.searchByAuthor(author);
    }

    //
    @DeleteMapping("/delete/by/{author}")
    public Mono<String> deleteByAuthor(@PathVariable String author) {
        return searchDatabase.deleteByAuthor(author);
    }
}

