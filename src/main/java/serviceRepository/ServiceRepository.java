package serviceRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.Service;

import java.io.IOException;

public interface ServiceRepository {

    void readFile() throws JsonProcessingException, IOException;

    void writeToFile() throws IOException;

    void createFile();

    void deleteFile();



}
