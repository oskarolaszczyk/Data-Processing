package tech.problem_workshop.data_processing;

import tech.problem_workshop.data_processing.dao.ResourcesStoryDao;
import tech.problem_workshop.data_processing.dao.StoryDAO;
import tech.problem_workshop.data_processing.timestamp_analysis.AverageOfMappedStories;
import tech.problem_workshop.data_processing.timestamp_analysis.StoriesMappedByHourOfTheWeek;
import tech.problem_workshop.data_processing.timestamp_analysis.TxtAnalysisFileGenerator;
import tech.problem_workshop.data_processing.utils.PropertiesLoader;

import java.io.IOException;

public class HourOfTheWeekAnalysisMain {
    public static void main(String[] args) throws IOException {
        StoryDAO storyDAO = new ResourcesStoryDao();
        var x = storyDAO.getAll("Data/" + PropertiesLoader.getJsonName());
        StoriesMappedByHourOfTheWeek mappedStories = new StoriesMappedByHourOfTheWeek(x);
        AverageOfMappedStories average = new AverageOfMappedStories(mappedStories);

        TxtAnalysisFileGenerator.writeTotalAverage(average,"Data/totalAverage.txt");
        TxtAnalysisFileGenerator.writeSelectedAverage(average,20,"Data/SelectedAverage20.txt");
    }
}
