public class test {

    public static void main(String[] args) {
        int[] numbersToSort = {44, 43, 18, 37, 27, 33};
        heapify(numbersToSort);

        System.out.println("Max-heap array:");
        for (int num : numbersToSort) {
            System.out.print(num + " ");
        }
    }

    static void maxHeapPercolateDown(int nodeIndex, int[] heapArray, int heapSize) {
        int childIndex = 2 * nodeIndex + 1;
        int value = heapArray[nodeIndex];

        while (childIndex < heapSize) {
            int maxValue = value;
            int maxIndex = -1;
            for (int i = 0; i < 2 && i + childIndex < heapSize; i++) {
                if (heapArray[i + childIndex] > maxValue) {
                    maxValue = heapArray[i + childIndex];
                    maxIndex = i + childIndex;
                }
            }

            if (maxValue == value) {
                return;
            }

            int temp = heapArray[nodeIndex];
            heapArray[nodeIndex] = heapArray[maxIndex];
            heapArray[maxIndex] = temp;

            nodeIndex = maxIndex;
            childIndex = 2 * nodeIndex + 1;
        }
    }

    static void heapify(int[] numbers) {
        int n = numbers.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapPercolateDown(i, numbers, n);
        }
    }
}
