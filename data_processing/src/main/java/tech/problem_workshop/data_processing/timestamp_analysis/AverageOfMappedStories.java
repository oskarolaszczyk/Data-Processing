package tech.problem_workshop.data_processing.timestamp_analysis;

import tech.problem_workshop.data_processing.model.Story;

import java.util.*;
import java.util.stream.Collectors;

public class AverageOfMappedStories {
    StoriesMappedByHourOfTheWeek storiesMappedByHourOfTheWeek;

    public AverageOfMappedStories(StoriesMappedByHourOfTheWeek storiesMappedByHourOfTheWeek) {
        this.storiesMappedByHourOfTheWeek = storiesMappedByHourOfTheWeek;
    }
    public double totalAverage(int hourOfTheWeek) {
        HashMap<Story,Integer> reducedStories = reduceMap(storiesMappedByHourOfTheWeek.getMappedStories(), hourOfTheWeek);

        double sum = 0.0;
        for(Story key : reducedStories.keySet()) {
           sum += key.getScore();

        }
        return sum / reducedStories.keySet().size();
    }
    public double selectedAverage(int topStories, int hourOfTheWeek){
        HashMap<Story,Integer> reducedStories = reduceMap(storiesMappedByHourOfTheWeek.getMappedStories(), hourOfTheWeek);
        List<Story> storyList = new ArrayList<>(reducedStories.keySet());
        storyList.sort((o1, o2) -> {
            int compareValue = o1.getScore().compareTo(o2.getScore());
            if (compareValue != 0) {
                return -compareValue;
            }
            return compareValue;
        });
        double sum = 0.0;
        for(int i = 0; i < topStories; i++) {
            sum += storyList.get(i).getScore();
        }
        return sum / topStories;

    }
    private HashMap<Story,Integer> reduceMap(HashMap<Story,Integer> storyMap, Integer hourOfTheWeek) {
        Map<Story, Integer> result = storyMap.entrySet()
                .stream()
                .filter(map -> hourOfTheWeek.equals(map.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new HashMap<>(result);
    }

}
