import java.util.Arrays;
import java.util.Random;

public class SearchTimeTest {

    public static void main(String[] args) {

        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
        Random random = new Random();

        System.out.printf("%-10s %-20s %-20s%n", "Size", "Seq Search (ms)", "Binary Search (ms)");

        for (int size : sizes) {

            int[] data = new int[size];

            // Fill sorted array of random ascending integers
            data[0] = random.nextInt(10) + 1;
            for (int i = 1; i < size; i++) {
                data[i] = data[i - 1] + random.nextInt(10) + 1;
            }

            // 1000 search values in same range
            int[] searchValues = new int[1000];
            for (int i = 0; i < searchValues.length; i++) {
                searchValues[i] = random.nextInt(size * 10) + 1;
            }

            // Timed Sequential Search
            long startSeq = System.nanoTime();
            for (int value : searchValues) {
                sequentialSearch(data, value);
            }
            long endSeq = System.nanoTime();
            long seqTime = (endSeq - startSeq) / 1_000_000;

            // Timed Binary Search
            long startBin = System.nanoTime();
            for (int value : searchValues) {
                binarySearch(data, value, 0, data.length - 1);
            }
            long endBin = System.nanoTime();
            long binTime = (endBin - startBin) / 1_000_000;

            // Report Results
            System.out.printf("%-10d %-20d %-20d%n", size, seqTime, binTime);

        }
    }

    // Optimized Sequential Search (sorted array)
    public static boolean sequentialSearch(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) {
                return true;
            }
            if (num > key) { // stop early!
                return false;
            }
        }
        return false;
    }

    // Recursive Binary Search
    public static boolean binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) return false;

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return true;
        } else if (arr[mid] > key) {
            return binarySearch(arr, key, low, mid - 1);
        } else {
            return binarySearch(arr, key, mid + 1, high);
        }
    }
}