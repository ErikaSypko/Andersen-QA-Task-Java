import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void printHiIfGreaterThanSeven(int number) {
        if (number > 7) System.out.println("Hi!");
    }

    public static void ifNameIsMatch(String name) {
        if (name.equalsIgnoreCase("Vyacheslav"))
            System.out.println("Hi, Vyacheslav");
        else
            System.out.println("No such name");
    }

    public static void ifNumberIsMultipleOf3() {
        int[] numbers = fillArray();
        AtomicInteger iteration = new AtomicInteger();
        System.out.println("Numbers that are multiples of 3:");
        Arrays.stream(numbers)
                .filter(num -> num % 3 == 0)
                .forEach(num -> System.out.println("Number " + (iteration.incrementAndGet()) + ": " + num));
    }

    public static int[] fillArray() {
        System.out.print("Enter a number of elements (positive number): ");
        int size = 0;
        while (size <= 0) {
            try {
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid positive number: ");
                    scanner.next();
                }
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Invalid size! Please enter a positive number: ");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter " + i + " element: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number: ");
                scanner.next();
            }
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    public static void task1() {
        System.out.println("Task 1:");
        int number = 0;
        try {
            System.out.println("Enter a number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
            number = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        printHiIfGreaterThanSeven(number);
    }

    public static void task2() {
        System.out.println("Task 2:");
        System.out.println("Enter a name: ");
        String name = scanner.next();
        ifNameIsMatch(name);
    }

    public static void task3() {
        System.out.println("Task 3:");
        ifNumberIsMultipleOf3();
    }

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter a task number (1-3): ");
            switch (scanner.nextInt()) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                default:
                    System.out.println("Invalid input! Please enter a valid number.");
                    break;
            }
            System.out.println("Do you want to continue? (y/n)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) flag = false;
        }
    }
}


/*
Task 4:
    The given bracket sequence [((())()(())]] is incorrect.
    To make the sequence correct, you need to replace the second-to-last closing bracket "]"
    with ")".
    The corrected sequence would be [((())()(()))]
 */
