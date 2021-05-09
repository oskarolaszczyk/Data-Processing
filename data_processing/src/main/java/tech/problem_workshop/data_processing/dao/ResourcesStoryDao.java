package tech.problem_workshop.data_processing.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.problem_workshop.data_processing.model.Story;
import tech.problem_workshop.data_processing.utils.StoryDTOToStoryMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResourcesStoryDao implements tech.problem_workshop.data_processing.dao.StoryDAO {

    private static List<Story> stories;

    @Override
    public List<Story> getAll(File file) throws IOException {
        if (Objects.isNull(stories)) {
            stories = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    StoryDTO storyDTO = mapper.readValue(currentLine, StoryDTO.class);
                    Story story = StoryDTOToStoryMapper.mapToStory(storyDTO);
                    stories.add(story);
                }
            }
        }
        // TODO: 06.05.2021  
        return stories;
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
