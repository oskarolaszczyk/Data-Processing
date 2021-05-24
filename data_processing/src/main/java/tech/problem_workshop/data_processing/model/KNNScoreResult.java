package tech.problem_workshop.data_processing.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class KNNScoreResult implements Serializable {
    private String[] storyTitle;
    private String[] storyText;
    private Integer storyScore;
    private Double avgNeighboursScore;
    private List<Integer> neighboursScores;

    public KNNScoreResult(String[] storyTitle, String[] storyText, Integer storyScore,
                          List<Integer> neighboursScores) {
        this.storyTitle = storyTitle;
        this.storyText = storyText;
        this.storyScore = storyScore;
        this.neighboursScores = neighboursScores;
        this.avgNeighboursScore = neighboursScores.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    public String[] getStoryTitle() {
        return storyTitle;
    }

    public String[] getStoryText() {
        return storyText;
    }

    public Integer getStoryScore() {
        return storyScore;
    }

    public Double getAvgNeighboursScore() {
        return avgNeighboursScore;
    }

    public List<Integer> getNeighboursScores() {
        return neighboursScores;
    }

    @Override
    public String toString() {
        return  String.join(" ", storyTitle) + "\n" +
                String.join(" ", storyText) + "\n" +
                storyScore + "\n" +
                avgNeighboursScore + "\n" +
                neighboursScores;
    }
}


