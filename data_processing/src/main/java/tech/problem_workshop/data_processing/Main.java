package tech.problem_workshop.data_processing;

import tech.problem_workshop.data_processing.dao.ResourcesStoryDao;
import tech.problem_workshop.data_processing.dao.StoryDAO;
import tech.problem_workshop.data_processing.utils.PropertiesLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StoryDAO storyDAO = new ResourcesStoryDao();
        var x = storyDAO.getAll("Data/" + PropertiesLoader.getJsonName());
        // Potrzebne do debugowania i podejrzenia co jest wewnątrz
        var y = 1;
    }
}
