package tech.problem_workshop.data_processing;

import tech.problem_workshop.data_processing.dao.KNNCommentsResultDAO;
import tech.problem_workshop.data_processing.dao.KNNScoreResultDAO;
import tech.problem_workshop.data_processing.dao.ResourcesStoryDao;
import tech.problem_workshop.data_processing.dao.StoryDAO;
import tech.problem_workshop.data_processing.knn.KNNClassifier;
import tech.problem_workshop.data_processing.knn.metric.ChebyshevMetric;
import tech.problem_workshop.data_processing.knn.metric.EuclideanMetric;
import tech.problem_workshop.data_processing.knn.metric.ManhattanMetric;
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
                return story == null || story.getTextAfterStem().length != 0 || story.getCommentsCount() == null ||
                        story.getCommentsCount() == -1 || story.getTitleAfterStem().length == 0;

            }
        });

        // Potrzebne do debugowania i podejrzenia co jest wewnątrz
        var y = 1;


        for (int i = 1; i <= 2; i++) {
            Collections.shuffle(x);
            Story toTrain = x.get(0);
            KNNClassifier knn = new KNNClassifier(10, x.subList(1, x.size()-1), new EuclideanMetric());
            knn.simulate(toTrain);

            KNNClassifier knn2 = new KNNClassifier(10, x.subList(1, x.size()-1), new ManhattanMetric());
            knn2.simulate(toTrain);

            KNNClassifier knn3 = new KNNClassifier(10, x.subList(1, x.size()-1), new ChebyshevMetric());
            knn3.simulate(toTrain);

            KNNScoreResultDAO knnScoreResultDAO = new KNNScoreResultDAO();
            knnScoreResultDAO.save("results/knn/scores/score" + i + ".txt", knn.getKnnScoreResultsToStoreInFile());

            KNNCommentsResultDAO knnCommentsResultDAO = new KNNCommentsResultDAO();
            knnCommentsResultDAO.save("results/knn/comments/comment" + i + ".txt", knn.getKnnCommentsResultsToStoreInFile());

            KNNScoreResultDAO knnScoreResultDAO2 = new KNNScoreResultDAO();
            knnScoreResultDAO2.save("results/knn/scores/score2" + i + ".txt", knn2.getKnnScoreResultsToStoreInFile());

            KNNCommentsResultDAO knnCommentsResultDAO2 = new KNNCommentsResultDAO();
            knnCommentsResultDAO2.save("results/knn/comments/comment2" + i + ".txt", knn2.getKnnCommentsResultsToStoreInFile());

            KNNScoreResultDAO knnScoreResultDAO3 = new KNNScoreResultDAO();
            knnScoreResultDAO3.save("results/knn/scores/score3" + i + ".txt", knn3.getKnnScoreResultsToStoreInFile());

            KNNCommentsResultDAO knnCommentsResultDAO3 = new KNNCommentsResultDAO();
            knnCommentsResultDAO3.save("results/knn/comments/comment3" + i + ".txt", knn3.getKnnCommentsResultsToStoreInFile());
        }

    }
}
