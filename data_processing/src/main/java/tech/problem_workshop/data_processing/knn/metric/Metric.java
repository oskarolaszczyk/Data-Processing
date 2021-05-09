package tech.problem_workshop.data_processing.knn.metric;

public interface Metric {

    public double calculateDistance(double[] articleArrayVector, double[] trainingArticleArrayVector);
}
