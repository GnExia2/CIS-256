import java.util.Scanner;

public class upsideDownTriangle {

    public static void drawTriangle(int baseLength, int spaces) {
        if (baseLength <= 0) {
            return; // Base case: stop when baseLength reaches 0
        }

        // Print leading spaces
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        // Print '*'
        for (int i = 0; i < baseLength; i++) {
            System.out.print("*");
        }

        System.out.println(); // Move to the next line

        // Recursive call with smaller baseLength and increased spaces
        drawTriangle(baseLength - 2, spaces + 1);
    }

    public static void drawTriangle(int baseLength) {
        drawTriangle(baseLength, 0); // Initial call with spaces = 0
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int baseLength;

        baseLength = scnr.nextInt();
        drawTriangle(baseLength);
    }
}
