package controller;

import service.Service;
import serviceRepository.ServiceRepository;
import serviceRepository.ServiceRepositoryImpl;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    ServiceRepository repo = new ServiceRepositoryImpl();


    boolean exitApp = false;
    int action = 0;

    public void run() throws IOException {

        while (!exitApp) {
            switch (askWhatUserWantsToDo()) {
                case 1:
                    repo.writeToFile();
                    break;
                case 2:
                    repo.readFile();
                    break;
                case 3:
                    repo.createFile();
                    break;
                case 4:
                    repo.deleteFile();
                    break;
                case 5:
                    exitApp = true;
                    break;
            }
        }
    }

    private int askWhatUserWantsToDo() {
        Scanner input = new Scanner(System.in);

            System.out.println("What would you like to do?");
            System.out.println("1: Add to file");
            System.out.println("2: Read file");
            System.out.println("3: Create a new file");
            System.out.println("4: Delete a file");
            System.out.println("5: Exit");

            try {
                action = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("Wrong input. Try again.");
                askWhatUserWantsToDo();
            }

            checkInput();

            return action;
    }

    private void checkInput() {
        if (action <= 0 || action >= 6) {
            System.out.println("Wrong input. Try again.");
            askWhatUserWantsToDo();
        }
    }



}
