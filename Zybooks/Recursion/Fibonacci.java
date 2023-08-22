import java.util.Scanner;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n < 0) {
            return -1; // Negative index values should return -1
        } else if (n == 0) {
            return 0; // Base case: fibonacci(0) is 0
        } else if (n == 1) {
            return 1; // Base case: fibonacci(1) is 1
        } else {
            // Recursively calculate fibonacci(n) using the formula: fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int startNum;

        startNum = scnr.nextInt();
        System.out.println("fibonacci(" + startNum + ") is " + fibonacci(startNum));
    }
}
