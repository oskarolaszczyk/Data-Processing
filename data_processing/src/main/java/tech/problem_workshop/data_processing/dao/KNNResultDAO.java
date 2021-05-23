package tech.problem_workshop.data_processing.dao;

import tech.problem_workshop.data_processing.model.KNNResult;

import java.io.*;
import java.util.List;

public class KNNResultDAO implements SaveDAO<KNNResult> {
    @Override
    public void save(String path, List<KNNResult> knnResults) throws IOException {
        File fout = new File(path);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (KNNResult result : knnResults) {
            bw.write(String.join(" ", result.getStoryTitle()).replace("\n", " "));
            bw.newLine();
            bw.write(String.join(" ", result.getStoryText()).replace("\n", " "));
            bw.newLine();
            bw.write(result.getStoryScore().toString());
            bw.newLine();
            bw.write(result.getAvgNeighboursScore().toString());
            bw.newLine();
            bw.write(result.getNeighboursScores().toString());
            bw.newLine();
        }
        bw.close();
    }
}
