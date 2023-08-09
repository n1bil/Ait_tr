package main.lesson_59_CharOrientedStream.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PassengersOnTheTitanic {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/main/lesson_59_CharOrientedStream/homework/file/train.csv"))) {
            String str = bufferedReader.readLine();
            String[] cells;
            str = bufferedReader.readLine();


            double totalFares = 0;
            int countClassOne = 0;
            int countClassTwo = 0;
            int countClassThree = 0;
            double totalFaresClassOne = 0;
            double totalFaresClassTwo = 0;
            double totalFaresClassThird = 0;
            int survivor = 0;
            int survivorsMale = 0;
            int non_survivors = 0;
            int survivorsFemale = 0;
            int non_survivorsMale = 0;
            int non_survivorsFemale = 0;
            int survivorsChildren = 0;
            int non_survivorsChildren = 0;

            while (str != null) {
                cells = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                str = bufferedReader.readLine();

                totalFares += Double.parseDouble(cells[9]);

                if (Integer.parseInt(cells[2]) == 1) {
                    countClassOne++;
                    totalFaresClassOne += Double.parseDouble(cells[9]);
                } else if (Integer.parseInt(cells[2]) == 2) {
                    countClassTwo++;
                    totalFaresClassTwo += Double.parseDouble(cells[9]);
                } else if (Integer.parseInt(cells[2]) == 3) {
                    countClassThree++;
                    totalFaresClassThird += Double.parseDouble(cells[9]);
                }

                if (Integer.parseInt(cells[1]) == 1) {
                    survivor++;
                } else if (Integer.parseInt(cells[1]) == 0) {
                    non_survivors++;
                }

                if (cells[4].equals("male") && Integer.parseInt(cells[1]) == 1) {
                    survivorsMale++;
                } else if (cells[4].equals("male") && Integer.parseInt(cells[1]) == 0) {
                    non_survivorsMale++;
                } else if (cells[4].equals("female") && Integer.parseInt(cells[1]) == 1) {
                    survivorsFemale++;
                } else if (cells[4].equals("female") && Integer.parseInt(cells[1]) == 0) {
                    non_survivorsFemale++;
                }

                if (!cells[5].isEmpty()) {
                    if (Double.parseDouble(cells[5]) < 18 && Double.parseDouble(cells[1]) == 1) {
                        survivorsChildren++;
                    } else if (Double.parseDouble(cells[5]) < 18 && Double.parseDouble(cells[1]) == 0) {
                        non_survivorsChildren++;
                    }
                }
            }


            System.out.println("Total fares = " + totalFares);
            System.out.println("Average fare for 1st class = " + totalFaresClassOne / countClassOne);
            System.out.println("Average fare for 2nd class = " + totalFaresClassTwo / countClassTwo);
            System.out.println("Average fare for 3rd class = " + totalFaresClassThird / countClassThree);
            System.out.println("Survivors = " + survivor);
            System.out.println("Non-survivors = " + non_survivors);
            System.out.println("Survivors male = " + survivorsMale);
            System.out.println("Non_survivors male = " + non_survivorsMale);
            System.out.println("Survivors female = " + survivorsFemale);
            System.out.println("Non_survivors female = " + non_survivorsFemale);
            System.out.println("Survivors children = " + survivorsChildren);
            System.out.println("Non_survivors children = " + non_survivorsChildren);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}