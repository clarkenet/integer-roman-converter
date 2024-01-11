package org.example;

import org.example.converter.IntegerToRomanConverter;
import org.example.converter.RomanToIntegerConverter;
import org.example.exception.ApplicationException;

import java.util.Scanner;

/**
 * The Main App class.
 */
public class Main {

    /**
     * Utility method to simulate clearing out the console. This also work with IDE consoles.
     */
    private static void clearConsole() {
        System.out.println(System.lineSeparator().repeat(50));
    }


    /**
     * Prints the main menu into the console.
     */
    private static void printMainMenu() {
        clearConsole();
        System.out.println("===== INTEGER - ROMAN NUMBER CONVERTER ======\n");
        System.out.println("Please select the desired option and press Enter:\n");
        System.out.println("\t1. Convert Integer to Roman number.");
        System.out.println("\t2. Convert Roman to Integer number.");
        System.out.println("\t0. Exit.\n");
        System.out.print("Option: ");
    }

    /**
     * Prints the integer to roman conversion menu and shows the resultant conversion.
     *
     * @param scanner An already created Scanner instance to handle user input
     */
    private static void printIntegerToRomanMenu(Scanner scanner) {
        clearConsole();
        System.out.println("Convert Integer to Roman number\n");

        var intToRomanConverter = new IntegerToRomanConverter();
        boolean shouldShowSubMenu = true;

        do {
            System.out.print("Type the integer value to be converted (1 - 3000) and press Enter: ");
            try {
                String strNumber = scanner.next();
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

    /**
     * Prints the roman to integer conversion menu and shows the resultant conversion.
     *
     * @param scanner An already created Scanner instance to handle user input
     */
    private static void printRomanToIntegerMenu(Scanner scanner) {
        clearConsole();
        System.out.println("Convert Roman to Integer number\n");

        var romanToIntConverter = new RomanToIntegerConverter();
        boolean shouldShowSubMenu = true;

        do {
            System.out.print("Type the roman value to be converted (I[1] - MMM[3000]) and press Enter: ");
            try {
                String strRoman = scanner.next();
                int intValue = romanToIntConverter.convertToInteger(strRoman);
                System.out.printf("The integer value of %s is: '%s'\n\n", strRoman.toUpperCase(), intValue);
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