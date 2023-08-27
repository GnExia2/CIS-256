import java.util.*;

public class Searcher<T> {
	// Returns the index of the key in the sorted array, or -1 if the
	// key is not found.
	public static <T> int binarySearch(T[] array, int arraySize, T key,
			Comparator<T> comparer) {

        int low = 0;
        int high = arraySize - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = comparer.compare(array[mid], key);

            if (comparison == 0) {
                return mid; // Key found
            } else if (comparison < 0) {
                low = mid + 1; // Key is greater, search upper half
            } else {
                high = mid - 1; // Key is smaller, search lower half
            }
        }

		// Your code here

		return -1;
	}
}
