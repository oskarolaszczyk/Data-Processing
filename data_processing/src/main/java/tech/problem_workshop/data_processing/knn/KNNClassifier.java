package tech.problem_workshop.data_processing.knn;

import tech.problem_workshop.data_processing.knn.metric.Metric;
import tech.problem_workshop.data_processing.knn.text_distance.Bigrams;
import tech.problem_workshop.data_processing.model.KNNResult;
import tech.problem_workshop.data_processing.model.Story;

import java.util.*;
import java.util.stream.Collectors;

public class KNNClassifier {

    private final int k;
    private Story story;
    private final List<Story> trainingStories;
    private final Metric metric;
    private List<KNNResult> knnResultsToStoreInFile;

    public KNNClassifier(int k, List<Story> trainingStories, Metric metric) {
        this.k = k;
        this.trainingStories = trainingStories;
        this.metric = metric;
        knnResultsToStoreInFile = new ArrayList<>();
    }

    public List<KNNResult> getKnnResultsToStoreInFile() {
        return knnResultsToStoreInFile;
    }

    public void simulate(Story story) {
        this.story = story;
        Map<Story, Double> neighbours = findKNearestNeighbours(sortMapWithDoubles(this.calculateDistances()));
        List<Integer> neighboursScores = new ArrayList<>();
        for (Story neighbour : neighbours.keySet()) {
            neighboursScores.add(neighbour.getScore());
        }
        int j = 0;

        knnResultsToStoreInFile.add(new KNNResult(story.getTitle(), story.getText(), story.getScore(), neighboursScores));
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
