package tech.problem_workshop.data_processing.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.Timestamp;

public class StoryDTO {
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("title")
    private String title;
    @JsonProperty("text")
    private String text;
    @JsonProperty("URL")
    private String URL;
    @JsonProperty("author_name")
    private String author;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("timestamp")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Timestamp timestamp;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("descendants")
    private Integer commentsCount;

    public StoryDTO() {
    }

    public StoryDTO(Integer score, String title, String URL, String author, Long time, Timestamp timestamp, Long id, Integer commentsCount, String text) {
        this.score = score;
        this.title = title;
        this.URL = URL;
        this.author = author;
        this.time = time;
        this.timestamp = timestamp;
        this.id = id;
        this.commentsCount = commentsCount;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }
}
