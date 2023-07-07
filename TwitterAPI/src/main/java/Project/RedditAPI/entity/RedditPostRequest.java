package Project.RedditAPI.entity;

public class RedditPostRequest {

    private String subReddit;
    private String title;
    private String content;
//    private String url;

    // getters and setters

    public String getSubReddit() {
        return subReddit;
    }

    public void setSubReddit(String subReddit) {
        this.subReddit = subReddit;
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

    public RedditPostRequest() {
    }

    public RedditPostRequest(String subReddit, String title, String content) {
        this.subReddit = subReddit;
        this.title = title;
        this.content = content;
    }
}
