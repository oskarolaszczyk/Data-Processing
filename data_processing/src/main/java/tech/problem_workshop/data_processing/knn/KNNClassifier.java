package tech.problem_workshop.data_processing.knn;

import tech.problem_workshop.data_processing.knn.metric.Metric;
import tech.problem_workshop.data_processing.knn.text_distance.Bigrams;
import tech.problem_workshop.data_processing.model.KNNCommentsResult;
import tech.problem_workshop.data_processing.model.KNNScoreResult;
import tech.problem_workshop.data_processing.model.Story;

import java.util.*;
import java.util.stream.Collectors;

public class KNNClassifier {

    private final int k;
    private Story story;
    private final List<Story> trainingStories;
    private final Metric metric;
    private List<KNNScoreResult> knnScoreResultsToStoreInFile;
    private List<KNNCommentsResult> knnCommentsResultsToStoreInFile;

    public KNNClassifier(int k, List<Story> trainingStories, Metric metric) {
        this.k = k;
        this.trainingStories = trainingStories;
        this.metric = metric;
        knnScoreResultsToStoreInFile = new ArrayList<>();
        knnCommentsResultsToStoreInFile = new ArrayList<>();
    }

    public List<KNNScoreResult> getKnnScoreResultsToStoreInFile() {
        return knnScoreResultsToStoreInFile;
    }

    public List<KNNCommentsResult> getKnnCommentsResultsToStoreInFile() {
        return knnCommentsResultsToStoreInFile;
    }

    public void simulate(Story story) {
        this.story = story;
        Map<Story, Double> neighbours = findKNearestNeighbours(sortMapWithDoubles(this.calculateDistances()));
        List<Integer> neighboursScores = new ArrayList<>();
        for (Story neighbour : neighbours.keySet()) {
            neighboursScores.add(neighbour.getScore());
        }
        List<Integer> neighboursCommentsCounts = new ArrayList<>();
        for (Story neighbour : neighbours.keySet()) {
            neighboursCommentsCounts.add(neighbour.getCommentsCount());
        }
        int j = 0;

        knnScoreResultsToStoreInFile.add(new KNNScoreResult(story.getTitle(), story.getText(),
                story.getScore(), neighboursScores));
        knnCommentsResultsToStoreInFile.add(new KNNCommentsResult(story.getTitle(), story.getText(),
                story.getCommentsCount(), neighboursCommentsCounts));
    }

    private Map<Story, Double> findKNearestNeighbours(Map<Story, Double> sortedMap) {
        return sortedMap.entrySet().stream().limit(this.k)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<Story, Double> calculateDistances() {
        Map<Story, Double> mapOfAnything = new HashMap<>();

        this.trainingStories.forEach(s -> mapOfAnything.put(s, metric.calculateDistance(new double[]{0,0},
                new double[]{1 - Bigrams.bigramSimilarity(String.join(" ", story.getTitleAfterStem()),
                        String.join(" ", s.getTitleAfterStem())), 1 - Bigrams.bigramSimilarity(String.join(" ", story.getTextAfterStem()),
                        String.join(" ", s.getTextAfterStem()))})));


        return mapOfAnything;
    }

    public Map<Story, Double> sortMapWithDoubles(Map<Story, Double> mapToSort) {
        Map<Story, Double> collect = mapToSort.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return collect;
    }
}
