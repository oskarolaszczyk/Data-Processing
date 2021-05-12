package tech.problem_workshop.data_processing;

import tech.problem_workshop.data_processing.dao.ResourcesStoryDao;
import tech.problem_workshop.data_processing.dao.StoryDAO;
import tech.problem_workshop.data_processing.knn.KNNClassifier;
import tech.problem_workshop.data_processing.knn.metric.EuclideanMetric;
import tech.problem_workshop.data_processing.model.Story;
import tech.problem_workshop.data_processing.utils.PropertiesLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StoryDAO storyDAO = new ResourcesStoryDao();
        var x = storyDAO.getAll("Data/" + PropertiesLoader.getJsonName());
        // Potrzebne do debugowania i podejrzenia co jest wewnątrz
        var y = 1;

        Story toTrain = x.get(0);
        KNNClassifier knn = new KNNClassifier(3, x.subList(1, x.size()-1), new EuclideanMetric());
        knn.simulate(toTrain);
    }
}
