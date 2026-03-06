import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data1 = {34, 7, 23, 32, 5, 62};

        // Use Randomized QuickSort
        SortHandler handler = new SortHandler(new QuickSortStrategy(true));
        System.out.println("Original: " + Arrays.toString(data1));

        handler.sort(data1, "ascending");
        System.out.println("QuickSort (Randomized): " + Arrays.toString(data1));

        // Switch to In-Place MergeSort at runtime
        int[] data2 = {34, 7, 23, 32, 5, 62};
        handler.setStrategy(new MergeSortStrategy(true));

        handler.sort(data2, "descending");
        System.out.println("MergeSort (In-Place Desc): " + Arrays.toString(data2));
    }
}