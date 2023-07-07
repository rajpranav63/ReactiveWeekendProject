package Project.RedditAPI.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "postdata")
public class PostData {

    @Id
    private  String id;

    private String subreddit;

    private  String title;

    private  String content;

    public PostData(String id, String subreddit, String title, String content) {
        this.id = id;
        this.subreddit = subreddit;
        this.title = title;
        this.content = content;
    }

    public PostData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
