import java.util.Scanner;

public class Calculator {
    private final Scanner scanner;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            System.out.println("\nSimple Java Calculator");
            System.out.println("Choose an operation:");
            System.out.println("1 - ADDITION");
            System.out.println("2 - SUBTRACTION");
            System.out.println("3 - MULTIPLICATION");
            System.out.println("4 - DIVISION");
            System.out.println("5 - EXIT");

            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number from 1 to 5.");
                scanner.next(); // discard invalid input
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice! Please select a number from 1 to 5.");
                continue;
            }

            double num1 = getValidNumber("Enter first number: ");
            double num2 = getValidNumber("Enter second number: ");

            double result = switch (choice) {
                case 1 -> add(num1, num2);
                case 2 -> subtract(num1, num2);
                case 3 -> multiply(num1, num2);
                case 4 -> divide(num1, num2);
                default -> 0; // should never hit this case due to previous validation
            };

            System.out.println("The result is: " + result);
        }
    }

    private double getValidNumber(String prompt) {
        double num;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                return num;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // discard invalid input
            }
        }
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }
}