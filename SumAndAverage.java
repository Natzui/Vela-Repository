import java.util.Scanner;

public class SumAndAverage {
    public static void main(String[] args) {
        try (Scanner Natz = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int N1 = Natz.nextInt();

            System.out.print("Enter a number: ");
            int N2 = Natz.nextInt();

            System.out.print("Enter a number: ");
            int N3 = Natz.nextInt();

            System.out.print("Enter a number: ");
            int N4 = Natz.nextInt();

            System.out.print("Enter a number: ");
            int N5 = Natz.nextInt();

            int total = N1 + N2 + N3 + N4 + N5;
            double average = total / 5.0;

            System.out.println("The total sum is: " + total);
            System.out.println("The average is: " + average);
        }
    }
}



/* 
import java.util.Scanner;

public class SumAndAverage {
    public static void main(String[] args) {
        Scanner Natz = new Scanner(System.in);
        int N1, N2, N3, N4, N5;

        // Get user inputs with validation
        N1 = getValidInput(Natz);
        N2 = getValidInput(Natz);
        N3 = getValidInput(Natz);
        N4 = getValidInput(Natz);
        N5 = getValidInput(Natz);

        int total = N1 + N2 + N3 + N4 + N5;
        double average = total / 5.0;

        System.out.println("The total sum is: " + total);
        System.out.println("The average is: " + average);
    }

    // Method to handle valid input and display a warning if invalid input is entered
    public static int getValidInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}

*/
