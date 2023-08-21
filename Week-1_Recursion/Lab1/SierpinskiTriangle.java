public class SierpinskiTriangle {
    static void printSierpinski(int n, int y, int x) {
        if (y == 0) {
            return;
        }

        printSpaces(y - 1); // Print leading spaces

        for (int i = 0; i + y < n; i++) {
            if ((i & (y - 1)) != 0) {
                System.out.print("   "); // Print double spaces
            } else {
                System.out.print("* "); // Print '*'
            }
        }

        System.out.println();

        printSierpinski(n, y - 1, x); // Recursive call for upper-left triangle
        printSierpinski(n, y - 1, x + 2 * (y - 1)); // Recursive call for upper-right triangle
    }

    static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String args[]) {
        int n = 32;
        int height = n / 2 + 1; // Calculate height of the main equilateral triangle

        // Function calling
        printSierpinski(n, height, 0);
    }
}
