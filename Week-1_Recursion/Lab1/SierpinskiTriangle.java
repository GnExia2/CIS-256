/**
  * @author Garrick Ngai
  * @since 8/25/2023
  */


import java.util.Scanner;

public class SierpinskiTriangle {
  static void printMenu() {
    System.out.println("Please input a power of 2");
    System.out.println("EX: 2, 4, 8, 16, 32, 64, ...");
  }

    
    /** 
     * @param n
     * @param y
     * @param x
     */
    static void printSierpinski(int n, int y, int x) {
        if (y < 0) {
            return;
        }

        printSpaces(y); // Print leading spaces

        for (int i = 0; i + y < n; i++) {
            if ((i & y) != 0) {
                System.out.print("  "); // Print double spaces
            } else {
                System.out.print("* "); // Print '*'
            }
        }

        System.out.println();

        printSierpinski(n, y - 1, x); // Recursive call for the next row
    }

    
    /** 
     * @param count
     */
    static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    /**
     * @param args
     */
    public static void main(String args[]) {
      Scanner scnr = new Scanner(System.in);
      printMenu();
      int n = scnr.nextInt();

        // Function calling
        printSierpinski(n, n - 1, 0); // Start from the bottom row
        scnr.close();
    }
}
