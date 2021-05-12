package tech.problem_workshop.data_processing.model;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Story {
    private String[] title;
    private String[] titleAfterStem;
    private String URL;
    private String author_name;
    private Integer score;
    private Long time;
    private Timestamp timestamp;
    private Long id;
    private Integer commentsCount;
    private String[] text;
    private String[] textAfterStem;
    private int hourOfTheWeek;

    public Story() {
    }

    public Story(String[] title, String[] titleAfterStem, String URL, String author_name, Integer score, Long time, Timestamp timestamp, Long id, Integer commentsCount, String[] text, String[] textAfterStem) {
        this.title = title;
        this.URL = URL;
        this.author_name = author_name;
        this.score = score;
        this.time = time;
        this.timestamp = timestamp;
        this.id = id;
        this.commentsCount = commentsCount;
        this.text = text;
        this.titleAfterStem = titleAfterStem;
        this.textAfterStem = textAfterStem;
        this.hourOfTheWeek = timestampToHourOfTheWeek(timestamp);
    }

    private int timestampToHourOfTheWeek(Timestamp timestamp) {
        LocalDateTime dateTime = timestamp.toLocalDateTime();
        return (dateTime.getHour()) + ((dateTime.getDayOfWeek().getValue() - 1) * 24);
    }
    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
        this.hourOfTheWeek = timestampToHourOfTheWeek(timestamp);
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

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public int getHourOfTheWeek() { return hourOfTheWeek; }
}
