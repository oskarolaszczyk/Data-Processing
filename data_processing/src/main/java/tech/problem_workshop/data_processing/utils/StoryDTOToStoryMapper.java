package tech.problem_workshop.data_processing.utils;

import opennlp.tools.stemmer.PorterStemmer;
import tech.problem_workshop.data_processing.model.Story;
import tech.problem_workshop.data_processing.dao.StoryDTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StoryDTOToStoryMapper {
    private StoryDTOToStoryMapper() {
    }

    public static Story mapToStory(StoryDTO storyDTO) {
        PorterStemmer porterStemmer = new PorterStemmer();
        String author = storyDTO.getAuthor();
        String[] title = new String[0];
        String[] titleAfterStem = new String[0];
        if (!Objects.isNull(storyDTO.getTitle())) {
            title = tokenize(storyDTO.getTitle());
            titleAfterStem = stem(title, porterStemmer);
        }
        String[] text = new String[0];
        String[] textAfterStem = new String[0];
        if (!Objects.isNull(storyDTO.getText())) {
            text = tokenize(storyDTO.getText());
            textAfterStem = stem(text, porterStemmer);
        }
        Long id = storyDTO.getId();
        String URL = storyDTO.getURL();
        Integer score = storyDTO.getScore();
        Long time = storyDTO.getTime();
        Timestamp timestamp = storyDTO.getTimestamp();
        Integer commentsCount = storyDTO.getCommentsCount();
        return new Story(title, titleAfterStem, URL, author, score, time, timestamp, id, commentsCount, text, textAfterStem);
    }

    private static String[] tokenize(String toTokenize) {
        return Arrays.asList(toTokenize.trim().replaceAll("[\\p{Punct}&&[^_-]]+", "").split(" +")).toArray(String[]::new);
    }

    private static String[] stem(String[] toStem, PorterStemmer porterStemmer) {
        List<String> tmp = Arrays.asList(toStem);
        List<String> afterStem = new ArrayList<>();
        tmp.forEach(s -> afterStem.add(porterStemmer.stem(s)));
        return afterStem.toArray(String[]::new);
    }

}
