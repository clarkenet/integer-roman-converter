package org.example;

import org.example.converter.IntegerToRomanConverter;
import org.example.exception.ApplicationException;

import java.util.Scanner;

public class Main {

    private static void clearConsole() {
        System.out.println(System.lineSeparator().repeat(50));
    }

    private static void printMainMenu() {
        clearConsole();
        System.out.println("===== INTEGER - ROMAN NUMBER CONVERTER ======\n");
        System.out.println("Please select the desired option and press Enter:\n");
        System.out.println("\t1. Convert Integer to Roman number.");
        System.out.println("\t2. Convert Roman to Integer number.");
        System.out.println("\t0. Exit.\n");
        System.out.print("Option: ");
    }

    private static void printIntegerToRomanMenu(Scanner scanner) {
        clearConsole();
        System.out.println("Convert Integer to Roman number\n");

        var intToRomanConverter = new IntegerToRomanConverter();
        boolean shouldShowSubMenu = true;

        do {
            System.out.print("Type the integer value to be converted (1 - 3000) and press Enter: ");
            String strNumber = scanner.next();
            try {
                String romanNumber = intToRomanConverter.convertToRoman(strNumber);
                System.out.printf("The roman number %s is: '%s'\n\n", strNumber, romanNumber);
                System.out.println("Press any key and Enter to get back to the main menu.");
                scanner.next();
                shouldShowSubMenu = false;
            } catch (ApplicationException applicationException) {
                System.out.println(applicationException.getMessage() + "\n");
            } catch (Exception exception) {
                System.out.println("Something went wrong, please try again.\n");
            }
        } while (shouldShowSubMenu);
    }

    private static void printRomanToIntegerMenu(Scanner scanner) {
        clearConsole();
        System.out.println("Sorry, this option is not currently available.\n");
        System.out.println("Press any key and Enter to get back to the main menu.");
        scanner.next();
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        while (shouldContinue) {
            printMainMenu();
            String option = scanner.next();

            switch (option) {
                case "1" -> printIntegerToRomanMenu(scanner);
                case "2" -> printRomanToIntegerMenu(scanner);
                case "0" -> {
                    System.out.println("Have a good day!");
                    Thread.sleep(1000);
                    shouldContinue = false;
                }
            }
        }
    }
}