package tech.problem_workshop.data_processing;

import tech.problem_workshop.data_processing.dao.ResourcesStoryDao;
import tech.problem_workshop.data_processing.dao.StoryDAO;
import tech.problem_workshop.data_processing.model.Story;
import tech.problem_workshop.data_processing.timestamp_analysis.AverageOfMappedStories;
import tech.problem_workshop.data_processing.timestamp_analysis.StoriesMappedByHourOfTheWeek;
import tech.problem_workshop.data_processing.timestamp_analysis.TxtAnalysisFileGenerator;
import tech.problem_workshop.data_processing.utils.PropertiesLoader;

import java.io.IOException;
import java.util.List;

public class HourOfTheWeekAnalysisMain {
    public static void main(String[] args) throws IOException {
        StoryDAO storyDAO = new ResourcesStoryDao();
        List<Story> x = storyDAO.getAll("Data/" + PropertiesLoader.getJsonName());
        StoriesMappedByHourOfTheWeek mappedStories = new StoriesMappedByHourOfTheWeek(x);
        AverageOfMappedStories average = new AverageOfMappedStories(mappedStories);
        String path = HourOfTheWeekAnalysisMain.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //"../../src/main/resources/Data/readableAverage.txt" Another option
        TxtAnalysisFileGenerator.writeReadable(average,path + "Data/readableAverage.txt");
       TxtAnalysisFileGenerator.writeReadableSelected(average,path + "Data/readableTopStoriesAverage.txt",20);
        TxtAnalysisFileGenerator.writeTotalAverage(average, path + "Data/jsonAverage.json");
        TxtAnalysisFileGenerator.writeSelectedAverage(average,20, path + "Data/jsonTopStoriesAverage.json");
    }
}
