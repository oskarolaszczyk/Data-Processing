package tech.problem_workshop.data_processing.dao;

import tech.problem_workshop.data_processing.model.Story;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface StoryDAO extends DAO<Story> {
    List<Story> getAll(File file) throws IOException;

    List<Story> getAll(String path) throws IOException;

    List<Story> getAll(URL path) throws IOException;
}
