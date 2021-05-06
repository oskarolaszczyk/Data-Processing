package tech.problem_workshop.data_processing.dao;

import tech.problem_workshop.data_processing.model.Story;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class ResourcesStoryDao implements StoryDAO {
    @Override
    public List<Story> getAll(File file) throws IOException {
        // TODO: 06.05.2021  
        return null;
    }

    @Override
    public List<Story> getAll(String path) throws IOException {
        return getAll(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(path)));
    }

    @Override
    public List<Story> getAll(URL path) throws IOException {
        return getAll(new File(path.getPath()));
    }
}
