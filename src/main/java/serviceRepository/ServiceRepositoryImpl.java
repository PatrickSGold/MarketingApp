package serviceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import controller.Controller;
import service.Service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ServiceRepositoryImpl implements ServiceRepository {
    Scanner input = new Scanner(System.in);

    public void readFile() throws IOException {
        File file = new File(existingFilePath());
        final ObjectMapper objectMapper = new ObjectMapper();

        try {
            final Service service = objectMapper.readValue(file, Service.class);
            System.out.println(service);
        }
        catch (IOException exception) {
            exception.getMessage();
            exception.getStackTrace();
        }

    }

    public void writeToFile() throws IOException {
        File file = new File(existingFilePath());
        Service service = new Service();
        service.setFieldValues();

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        try {
            writer.writeValue(file, service);
        }
        catch (IOException exception) {
            System.out.println("An error occurred");
            Controller controller = new Controller();
            controller.run();
        }

        System.out.println("The text has been submitted to the file.");
    }

    public void createFile() {
        try {
            File newFile = new File(newFilePath());
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        try {
            File file = new File(existingFilePath());
            if (file.exists()) {
                deleteConfirmation();
                file.delete();
                System.out.println("File deleted");
            }
        }
        catch (SecurityException | IOException exception) {
            System.out.println("An error occurred");
        }
    }

    private void deleteConfirmation() throws IOException {
        System.out.println("Are you sure you want to delete this file? Enter yes or no." );
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
        }
        else if (answer.equalsIgnoreCase("no")) {
            Controller controller = new Controller();
            controller.run();
        }
        else {
            System.out.println("Wrong input. Try again.");
            deleteFile();
        }
    }

    public void updateFile() {
        // modify something in file
    }

    private String existingFilePath() throws IOException {
        String filePath;

        System.out.println("Please enter the file path: ");
        filePath = input.nextLine();

        checkIfFileExist(filePath);

        return filePath;
    }

    private void checkIfFileExist(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            Controller controller = new Controller();
            controller.run();
        }
    }

    private String newFilePath() {
        System.out.println("Please enter the filepath for the file you would like to add: ");
        return input.nextLine();
    }

}
