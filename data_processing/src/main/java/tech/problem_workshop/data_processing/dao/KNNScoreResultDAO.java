package tech.problem_workshop.data_processing.dao;

import tech.problem_workshop.data_processing.model.KNNScoreResult;

import java.io.*;
import java.util.List;

public class KNNScoreResultDAO implements SaveDAO<KNNScoreResult> {
    @Override
    public void save(String path, List<KNNScoreResult> knnScoreResults) throws IOException {
        File fout = new File(path);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (KNNScoreResult result : knnScoreResults) {
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
