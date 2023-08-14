package main.lesson_61.classwork.restaurant.configuration;

import main.lesson_61.classwork.restaurant.dao.Restaurant;
import main.lesson_61.classwork.restaurant.dao.RestaurantImpl;
import main.lesson_61.classwork.restaurant.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BotConfiguration {
    public static void talkToTheBot() {
        Restaurant restaurant = new RestaurantImpl();

        while (true) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                Thread.sleep(3000);
                System.out.println("\n" + restaurant.welcome());
                System.out.println("If you want to reserve a table enter \"1\", if you want to leave press \"2\"");
                String userInput = bufferedReader.readLine();

                if (userInput.equalsIgnoreCase("switch off")) {
                    break;
                }

                long phoneNumber;
                switch (userInput) {
                    case "1" -> {
                        System.out.print("Enter your name: ");
                        String name = bufferedReader.readLine();
                        System.out.print("Enter your phone number: ");
                        phoneNumber = Long.parseLong(bufferedReader.readLine());
                        restaurant.reserveTable(new Client(name, phoneNumber));
                    }
                    case "2" -> {
                        System.out.print("Enter your phone number: ");
                        phoneNumber = Long.parseLong(bufferedReader.readLine());
                        restaurant.removeReservation(phoneNumber);
                    }
                    default -> System.out.println("Invalid input. Please enter a valid option.");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
