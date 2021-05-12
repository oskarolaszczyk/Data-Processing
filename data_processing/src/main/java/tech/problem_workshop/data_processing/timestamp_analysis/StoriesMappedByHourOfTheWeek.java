package tech.problem_workshop.data_processing.timestamp_analysis;

import tech.problem_workshop.data_processing.model.Story;

import java.util.HashMap;
import java.util.List;

public class StoriesMappedByHourOfTheWeek {
    private final HashMap<Story, Integer> mappedStories;
    private final List<Story> stories;

    public StoriesMappedByHourOfTheWeek(List<Story> stories) {
        this.stories = stories;
        this.mappedStories = mapStories();
    }

    private HashMap<Story, Integer> mapStories() {
        for (Story story : this.stories) {
            this.mappedStories.put(story, story.getHourOfTheWeek());
        }
        return this.mappedStories;
    }

    public HashMap<Story, Integer> getMappedStories() {
        return mappedStories;
    }

}
