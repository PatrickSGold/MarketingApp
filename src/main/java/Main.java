import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import controller.Controller;
import service.Service;
import serviceRepository.ServiceRepository;
import serviceRepository.ServiceRepositoryImpl;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();

        controller.run();

    }
}
