package tech.problem_workshop.data_processing.model;

import java.util.List;

public class KNNCommentsResult {
    private String[] storyTitle;
    private String[] storyText;
    private Integer storyCommentsCount;
    private Double avgNeighboursCommentsCount;
    private List<Integer> neighboursCommentsCount;

    public KNNCommentsResult(String[] storyTitle, String[] storyText, Integer storyCommentsCount, List<Integer> neighboursCommentsCount) {
        this.storyTitle = storyTitle;
        this.storyText = storyText;
        this.storyCommentsCount = storyCommentsCount;
        this.neighboursCommentsCount = neighboursCommentsCount;
        this.avgNeighboursCommentsCount = neighboursCommentsCount.stream()
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

    public Integer getStoryCommentsCount() {
        return storyCommentsCount;
    }

    public Double getAvgNeighboursCommentsCount() {
        return avgNeighboursCommentsCount;
    }

    public List<Integer> getNeighboursCommentsCount() {
        return neighboursCommentsCount;
    }
}
