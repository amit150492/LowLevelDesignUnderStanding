import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7};

        // --- Testing Randomized QuickSort ---
        SortHandler qsh = new SortHandler(new QuickSortStrategy(true));
        System.out.println("Original: " + Arrays.toString(data));

        qsh.sort(data, "asc");
        System.out.println("QuickSort (Asc): " + Arrays.toString(data));

        // --- Testing In-Place MergeSort ---
        int[] data2 = {12, 11, 13, 5, 6, 7}; // fresh array
        SortHandler msh = new SortHandler(new MergeSortStrategy(true));

        msh.sort(data2, "desc");
        System.out.println("MergeSort (Desc): " + Arrays.toString(data2));
    }
}