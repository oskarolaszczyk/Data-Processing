package tech.problem_workshop.data_processing.timestamp_analysis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

public class TxtAnalysisFileGenerator {

    public static void writeTotalAverage(AverageOfMappedStories avg, String filepath) {
        LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
        for(int i = 0; i < 168; i++) {
            averageScore.put(i,avg.totalAverage(i));
        }
            WriteObjectToFile(averageScore, filepath);
    }
    public static void writeTotalAverage(AverageOfMappedStories avg,int hourOfTheWeek, String filepath) {
            LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
            averageScore.put(hourOfTheWeek,avg.totalAverage(hourOfTheWeek));
            WriteObjectToFile(averageScore,filepath + hourOfTheWeek);
    }

    public static void writeSelectedAverage(AverageOfMappedStories avg, int topStories, String filepath) {
        LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
        for(int i = 0; i < 168; i++) {
            averageScore.put(i,avg.selectedAverage(topStories, i));
        }
        WriteObjectToFile(averageScore, filepath);
    }
    public static void writeSelectedAverage(AverageOfMappedStories avg, int topStories, int hourOfTheWeek, String filepath) {
        LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
        averageScore.put(hourOfTheWeek,avg.selectedAverage(topStories,hourOfTheWeek));
        WriteObjectToFile(averageScore,filepath + hourOfTheWeek);
    }
    private static void WriteObjectToFile(Object serObj, String filepath) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(filepath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(serObj);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in" + filepath);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
