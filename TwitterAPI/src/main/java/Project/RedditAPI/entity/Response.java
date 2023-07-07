package Project.RedditAPI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("data")
    private Data data;

    // Getters and setters
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        @JsonProperty("after")
        private String after;

        @JsonProperty("dist")
        private int dist;

        @JsonProperty("children")
        private Child[] children;

        // Getters and setters


        public String getAfter() {
            return after;
        }

        public void setAfter(String after) {
            this.after = after;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public Child[] getChildren() {
            return children;
        }

        public void setChildren(Child[] children) {
            this.children = children;
        }
    }

    public static class Child {
        @JsonProperty("kind")
        private String kind;

        @JsonProperty("data")
        private ChildData childData;

        // Getters and setters

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public ChildData getChildData() {
            return childData;
        }

        public void setChildData(ChildData childData) {
            this.childData = childData;
        }
    }

    public static class ChildData {
        @JsonProperty("selftext")
        private String selftext;

        @JsonProperty("author_fullname")
        private  String authorFullName;

        @JsonProperty("title")
        private String title;

        @JsonProperty("score")
        private Long score;

        @JsonProperty("author")
        private  String author;

        @JsonProperty("domain")
        private String domain;

        @JsonProperty("created")
        private  Long created;
        // Getters and setters


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
    }
}

