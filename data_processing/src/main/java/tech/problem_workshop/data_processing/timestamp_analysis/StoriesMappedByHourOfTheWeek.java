package tech.problem_workshop.data_processing.timestamp_analysis;

import tech.problem_workshop.data_processing.model.Story;

import java.util.HashMap;
import java.util.List;

public class StoriesMappedByHourOfTheWeek {
    private  HashMap<Story, Integer> mappedStories;

    public StoriesMappedByHourOfTheWeek(List<Story> stories) {
        this.mappedStories = mapStories(stories);
    }

    public HashMap<Story, Integer> mapStories(List<Story> stories) {
        HashMap<Story, Integer> buffer = new HashMap<>();
        for (Story story : stories) {
            buffer.put(story, story.getHourOfTheWeek());
        }
        return buffer;
    }

    public HashMap<Story, Integer> getMappedStories() {
        return mappedStories;
    }

}
