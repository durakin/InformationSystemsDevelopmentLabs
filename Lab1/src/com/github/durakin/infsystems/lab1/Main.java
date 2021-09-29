package com.github.durakin.infsystems.lab1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        final List<Vessel> vessels = new ArrayList<>();
        var reader = new BufferedReader(new InputStreamReader(System.in));
        boolean lastMenuIteration = false;
        while (!lastMenuIteration) {
            System.out.println("""
                    1. Add new steamboat instance
                    2. Add new sailboat instance
                    3. Add mew corvette instance
                    4. Print all elements
                    5. Delete element by index
                    6. Check if two elements are equal by indexes
                    7. Quit
                    """);

            var cmdNumber = CheckedIntInput("Enter required command number (1-7) ", reader, Main::CommandNumberChecker);

            switch (cmdNumber) {
                case 1 -> {
                    var name = CheckedStringInput("Enter steamboat's name ", reader, Main::StringChecker);
                    var tonnage = CheckedIntInput("Enter steamboat's tonnage (in tonnes, integer) ", reader, Main::PositiveIntegerChecker);
                    var fuelType = CheckedStringInput("Enter steamboat's type of fuel ", reader, Main::StringChecker);
                    var fuelConsumption = CheckedIntInput("Enter steamboat's fuel consumption (in standard for this type measure, integer) ", reader, Main::PositiveIntegerChecker);
                    vessels.add(new Steamboat(name, tonnage, fuelType, fuelConsumption));
                }
                case 2 -> {
                    var name = CheckedStringInput("Enter sailboat's name ", reader, Main::StringChecker);
                    var tonnage = CheckedIntInput("Enter sailboat's tonnage (in tonnes, integer) ", reader, Main::PositiveIntegerChecker);
                    var sailsPlan = CheckedStringInput("Enter sailboat's sails plan ", reader, Main::StringChecker);
                    var gunsInstalled = CheckedIntInput("Enter number of guns installed on sailboat) ", reader, Main::PositiveIntegerChecker);
                    vessels.add(new Sailboat(name, tonnage, sailsPlan, gunsInstalled));
                }
                case 3 -> {
                    var name = CheckedStringInput("Enter corvette's name ", reader, Main::StringChecker);
                    var tonnage = CheckedIntInput("Enter corvette's tonnage (in tonnes, integer) ", reader, Main::PositiveIntegerChecker);
                    var artillery = CheckedStringInput("Enter corvette's artillery info ", reader, Main::StringChecker);
                    var speed = CheckedIntInput("Enter maximal speed of corvette (in knots, integer) ", reader, Main::PositiveIntegerChecker);
                    vessels.add(new Corvette(name, tonnage, artillery, speed));
                }
                case 4 -> {
                    for (var i : vessels) {
                        System.out.println(i.toString() + '\n');
                    }
                }
                case 5 -> {
                    var indexToDelete = CheckedIntInput("Enter index of element to delete: ", reader, Main::PositiveIntegerChecker);
                    vessels.remove(indexToDelete);
                }
                case 6 -> {
                    var indexToCompare1 = CheckedIntInput("Enter index of first element to compare: ", reader, Main::PositiveIntegerChecker);
                    var indexToCompare2 = CheckedIntInput("Enter index of other element to compare: ", reader, Main::PositiveIntegerChecker);
                    try {
                        System.out.println(vessels.get(indexToCompare1).equals(vessels.get(indexToCompare2)) ? "Elements are equal" : "Elements are not equal");
                    } catch (IndexOutOfBoundsException exception) {
                        System.out.println("Index is out of bounds of list of vessels");
                    }
                }
                case 7 -> lastMenuIteration = true;
            }
        }

        System.out.println();
    }


    private static int CheckedIntInput(String message, BufferedReader reader, Function<Integer, Boolean> checker) {
        while (true) {
            try {
                System.out.print(message);
                var number = Integer.parseInt(reader.readLine());
                if (!checker.apply(number)) {
                    throw new Exception("Не в промежутке");
                }
                return number;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static String CheckedStringInput(String message, BufferedReader reader, Function<String, Boolean> checker) {
        while (true) {
            try {
                System.out.print(message);
                var string = reader.readLine();
                if (!checker.apply(string)) {
                    throw new Exception("String is empty");
                }
                return string;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static boolean CommandNumberChecker(int number) {
        return 1 <= number && number <= 7;
    }

    private static boolean PositiveIntegerChecker(int number) {
        return 0 <= number && number < 10000;
    }

    private static boolean StringChecker(String string) {
        return string != null && !string.isBlank();
    }


}
