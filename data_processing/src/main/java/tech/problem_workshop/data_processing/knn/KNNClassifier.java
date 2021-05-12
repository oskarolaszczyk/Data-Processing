package tech.problem_workshop.data_processing.knn;

import tech.problem_workshop.data_processing.knn.metric.Metric;
import tech.problem_workshop.data_processing.model.Story;

import java.util.List;

public class KNNClassifier {

    private final int k;
    private Story story;
    private final List<Story> trainingStories;
    private final Metric metric;

    public KNNClassifier(int k, List<Story> trainingStories, Metric metric) {
        this.k = k;
        this.trainingStories = trainingStories;
        this.metric = metric;
    }

    public void simulate(Story story) {
        this.story = story;
        this.calculateDistances();

    }

    private void calculateDistances() {
        for (Story trainingStory: this.trainingStories) {

        }
    }
}
