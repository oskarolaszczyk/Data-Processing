package tech.problem_workshop.data_processing.dao;

import tech.problem_workshop.data_processing.model.KNNCommentsResult;
import tech.problem_workshop.data_processing.model.KNNScoreResult;

import java.io.*;
import java.util.List;

public class KNNCommentsResultDAO implements SaveDAO<KNNCommentsResult> {
    @Override
    public void save(String path, List<KNNCommentsResult> knnCommentsResults) throws IOException {
        File fout = new File(path);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (KNNCommentsResult result : knnCommentsResults) {
            bw.write(String.join(" ", result.getStoryTitle()).replace("\n", " "));
            bw.newLine();
            bw.write(String.join(" ", result.getStoryText()).replace("\n", " "));
            bw.newLine();
            bw.write(result.getStoryCommentsCount().toString());
            bw.newLine();
            bw.write(result.getAvgNeighboursCommentsCount().toString());
            bw.newLine();
            bw.write(result.getNeighboursCommentsCount().toString());
            bw.newLine();
        }
        bw.close();
    }
}
