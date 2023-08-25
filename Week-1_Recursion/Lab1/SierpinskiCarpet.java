/**
  * @author Garrick Ngai
  * @since 8/25/2023
  */

public class SierpinskiCarpet {

    public static void main(String[] args) {
        int size = 27; // You can adjust this value to change the size of the carpet
        char[][] carpet = new char[size][size];

        // Initialize the carpet with spaces
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                carpet[i][j] = ' ';
            }
        }

        drawSierpinski(carpet, 0, 0, size);

        // Print the carpet
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(carpet[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawSierpinski(char[][] carpet, int x, int y, int size) {
        if (size == 1) {
            carpet[y][x] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // Leave the center blank
                    continue;
                } else {
                    drawSierpinski(carpet, x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }
}
