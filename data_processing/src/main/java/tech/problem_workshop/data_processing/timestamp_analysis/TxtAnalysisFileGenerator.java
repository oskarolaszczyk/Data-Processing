package tech.problem_workshop.data_processing.timestamp_analysis;

import com.google.gson.Gson;

import java.io.*;
import java.util.LinkedHashMap;

public class TxtAnalysisFileGenerator {

    public static void writeTotalAverage(AverageOfMappedStories avg, String filepath) {
        LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
        for(int i = 0; i < 168; i++) {
            averageScore.put(i,avg.totalAverage(i));
        }

            writeObjectToFile(new Gson().toJson(averageScore, LinkedHashMap.class), filepath);
    }
    public static void writeTotalAverage(AverageOfMappedStories avg,int hourOfTheWeek, String filepath) {
            LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
            averageScore.put(hourOfTheWeek,avg.totalAverage(hourOfTheWeek));
            writeObjectToFile(new Gson().toJson(averageScore, LinkedHashMap.class),filepath + hourOfTheWeek);
    }

    public static void writeSelectedAverage(AverageOfMappedStories avg, int topStories, String filepath) {
        LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
        for(int i = 0; i < 168; i++) {
            averageScore.put(i,avg.selectedAverage(topStories, i));
        }
        writeObjectToFile(new Gson().toJson(averageScore, LinkedHashMap.class), filepath);
    }
    public static void writeSelectedAverage(AverageOfMappedStories avg, int topStories, int hourOfTheWeek, String filepath) {
        LinkedHashMap<Integer,Double> averageScore = new LinkedHashMap<>();
        averageScore.put(hourOfTheWeek,avg.selectedAverage(topStories,hourOfTheWeek));
        writeObjectToFile(new Gson().toJson(averageScore, LinkedHashMap.class),filepath + hourOfTheWeek);
    }
    public static void writeReadable(AverageOfMappedStories avg, String filepath) {
        try (StringWriter sw = new StringWriter(); BufferedWriter bw = new BufferedWriter(sw)) {

            for(int i = 0; i < 168; i++) {
                bw.write("For hour " + i + " of the week Average of stories is: " + avg.totalAverage(i));
                bw.newLine();
            }
            bw.flush();

            writeObjectToFile(sw.getBuffer().toString(),filepath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeReadableSelected(AverageOfMappedStories avg, String filepath, Integer topStories) {
        try (StringWriter sw = new StringWriter(); BufferedWriter bw = new BufferedWriter(sw)) {
            for (int i = 0; i < 168; i++) {
                bw.write("For hour " + i +  " of the week, average of TOP" + topStories + " stories is: " + avg.selectedAverage(topStories, i));
                bw.newLine();
            }
            bw.flush();
            // print
            writeObjectToFile(sw.getBuffer().toString(), filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeObjectToFile(Object serObj, String filepath) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(filepath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(serObj);
            out.close();
            fileOut.close();
            System.out.print("\nSerialized data is saved in " + filepath);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    }
