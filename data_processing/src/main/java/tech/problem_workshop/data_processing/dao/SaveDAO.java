package tech.problem_workshop.data_processing.dao;

import tech.problem_workshop.data_processing.model.KNNResult;

import java.io.IOException;
import java.util.List;

// nie rozszerzam DAO, bo tam bym musiał dodac save, a nie chciałem mieszac w
// istniejacych klasach
public interface SaveDAO<T> {

    void save(String path, List<T> results) throws IOException;
}
