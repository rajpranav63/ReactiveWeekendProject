package Project.RedditAPI.Search;

import Project.RedditAPI.entity.RedditData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SearchDatabase {
    public Flux<RedditData> searchByAuthor(String author);

    public Mono<String> deleteByAuthor(String author);

    public Flux<RedditData> searchAllPosts();
}
