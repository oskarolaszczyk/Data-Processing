package tech.problem_workshop.data_processing;

import tech.problem_workshop.data_processing.dao.KNNCommentsResultDAO;
import tech.problem_workshop.data_processing.dao.KNNScoreResultDAO;
import tech.problem_workshop.data_processing.dao.ResourcesStoryDao;
import tech.problem_workshop.data_processing.dao.StoryDAO;
import tech.problem_workshop.data_processing.knn.KNNClassifier;
import tech.problem_workshop.data_processing.knn.metric.EuclideanMetric;
import tech.problem_workshop.data_processing.model.Story;
import tech.problem_workshop.data_processing.utils.PropertiesLoader;

import java.io.IOException;
import java.util.Collections;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        StoryDAO storyDAO = new ResourcesStoryDao();
        var x = storyDAO.getAll("Data/" + PropertiesLoader.getJsonName());
        x.removeIf(new Predicate<Story>() {
            @Override
            public boolean test(Story story) {
                return story == null || story.getTextAfterStem().length == 0 || story.getCommentsCount() == null ||
                        story.getCommentsCount() == -1;

            }
        });

        // Potrzebne do debugowania i podejrzenia co jest wewnątrz
        var y = 1;


        for (int i = 1; i <= 3; i++) {
            Collections.shuffle(x);
            Story toTrain = x.get(0);
            KNNClassifier knn = new KNNClassifier(10, x.subList(1, x.size()-1), new EuclideanMetric());
            knn.simulate(toTrain);

            KNNScoreResultDAO knnScoreResultDAO = new KNNScoreResultDAO();
            knnScoreResultDAO.save("results/knn/scores/score" + i + ".txt", knn.getKnnScoreResultsToStoreInFile());

            KNNCommentsResultDAO knnCommentsResultDAO = new KNNCommentsResultDAO();
            knnCommentsResultDAO.save("results/knn/comments/comment" + i + ".txt", knn.getKnnCommentsResultsToStoreInFile());
        }

    }
}
