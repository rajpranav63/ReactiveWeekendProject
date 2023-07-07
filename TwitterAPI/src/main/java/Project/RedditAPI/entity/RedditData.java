package Project.RedditAPI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RedditPost")
public class RedditData {
    @Id
    private String id;
    private String selftext;

    private String authorFullName;

    private String title;

    private Long score;

    private String author;

    private String domain;

    private Long created;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public RedditData() {
    }

    public RedditData(String id, String selftext, String authorFullName, String title, Long score, String author, String domain, Long created, String date) {
        this.id = id;
        this.selftext = selftext;
        this.authorFullName = authorFullName;
        this.title = title;
        this.score = score;
        this.author = author;
        this.domain = domain;
        this.created = created;
        this.date = date;
    }
}
