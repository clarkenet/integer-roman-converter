package org.example;

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
        System.out.println("\t0. Exit..\n");
        System.out.print("Option: ");
    }

    private static void printIntegerToRomanMenu() {
        System.out.println("Option 1 selected\n");
    }

    private static void printRomanToIntegerMenu() {
        System.out.println("Option 2 selected\n");
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        while (shouldContinue) {
            printMainMenu();
            String option = scanner.next();

            switch (option) {
                case "1" -> printIntegerToRomanMenu();
                case "2" -> printRomanToIntegerMenu();
                case "0" -> {
                    System.out.println("Have a good day!");
                    Thread.sleep(1000);
                    shouldContinue = false;
                }
            }
        }
    }
}