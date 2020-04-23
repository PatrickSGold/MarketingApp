package service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Service {
    Scanner input = new Scanner(System.in);

    @JsonProperty("marketingManager")
    private String marketingManagerName = null;

    @JsonProperty("area")
    private String area = null;

    @JsonProperty("storeName")
    private String storeName = null;

    @JsonProperty("whatWasDoneToday")
    private String whatWasDoneToday = null;

    @JsonProperty("productsGiven")
    private int productsGiven = 0;

    @JsonProperty("spokeToManager")
    private Boolean spokeToManager = null;


    public void setFieldValues() {
        setArea();
        setStoreName();
        setWhatWasDoneToday();
        setProductsGiven();
        setSpokeToManager();
    }

    private void setArea() {
        System.out.print("Please enter the area of the store: ");
        area = input.nextLine();
    }

    private void setStoreName() {
        System.out.print("Please enter the store's name: ");
        storeName = input.nextLine();
    }
    private void setWhatWasDoneToday() {
        System.out.print("Please write you have done today: ");
        whatWasDoneToday = input.nextLine();
    }

    private void setProductsGiven() {
        try {
            System.out.print("Enter amount of products given to the store: ");
            productsGiven = input.nextInt();
        }

        catch (NumberFormatException exception) {   // not sure if this is right exception..

        }
    }

    private void setSpokeToManager() {
        try {
            System.out.print("Did you speak to the manager today? Enter 1 for yes, or 2 for no: ");
            int answer = input.nextInt();

            if (answer == 1) {
                spokeToManager = true;
            } else if (answer == 2) {
                spokeToManager = false;
            } else {
                System.out.println("Wrong input. Try again.");
                setSpokeToManager();
            }
        }
        catch (InputMismatchException exception) {
            System.out.println("Wrong input. Try again.");
            setSpokeToManager();
        }
    }

    public String getArea() {
        return area;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getProductsGiven() {
        return productsGiven;
    }

    public String getWhatWasDoneToday() {
        return whatWasDoneToday;
    }

    public Boolean getSpokeToManager() {
        return spokeToManager;
    }

    @Override
    public String toString() {
        String s = "Area = " + area + "\n"
                + "Store name = " + storeName + "\n"
                + "What was done today = " + whatWasDoneToday + "\n"
                + "Amount of products given to store = " + productsGiven + "\n"
                + "Spoken to manager = " + spokeToManager;

        return s;
    }



}
