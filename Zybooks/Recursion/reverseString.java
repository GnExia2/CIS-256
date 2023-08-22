import java.util.Scanner;

public class LabProgram {

    public static String reverseString(String str) {
        // Base case: when the string is empty or has only one character
        if (str.length() <= 1) {
            return str;
        } else {
            // Move the first character to the end and call reverseString() on the remaining substring
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input, result;

        input = scnr.nextLine();
        result = reverseString(input);
        System.out.printf("Reverse of \"%s\" is \"%s\".", input, result);
    }
}
