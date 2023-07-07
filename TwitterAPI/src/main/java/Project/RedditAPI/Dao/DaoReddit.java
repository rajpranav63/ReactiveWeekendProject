package Project.RedditAPI.Dao;

import Project.RedditAPI.entity.RedditData;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface DaoReddit extends ReactiveMongoRepository<RedditData,String> {
    Flux<RedditData> findBySelftextContaining(String keyword);

    Flux<RedditData> findByAuthor(String author);

    Flux<RedditData> findAllByOrderByDateAsc(Sort sort);

    Flux<RedditData> findBySelftextContainingAndAuthor(String keyword, String author);

    void deleteByAuthor(String author);
}
