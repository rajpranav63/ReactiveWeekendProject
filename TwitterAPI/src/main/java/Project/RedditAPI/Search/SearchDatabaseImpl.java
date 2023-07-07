package Project.RedditAPI.Search;

import Project.RedditAPI.entity.RedditData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SearchDatabaseImpl implements SearchDatabase {
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Autowired
    public SearchDatabaseImpl(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Flux<RedditData> searchByAuthor(String author) {
        Query query = new Query(Criteria.where("author").is(author));
        return reactiveMongoTemplate.find(query, RedditData.class);
    }

    @Override
    public Mono<String> deleteByAuthor(String author) {
        Query query = new Query(Criteria.where("author").is(author));
        return reactiveMongoTemplate.remove(query, RedditData.class)
                .map(deleteResult -> "Post Deleted by " + author);
    }

    @Override
    public Flux<RedditData> searchAllPosts() {
        Query query = new Query();
        return reactiveMongoTemplate.find(query, RedditData.class);
    }
}

