package Project.RedditAPI.Dao;

import Project.RedditAPI.entity.PostData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoPostData extends ReactiveMongoRepository<PostData,String> {

}
