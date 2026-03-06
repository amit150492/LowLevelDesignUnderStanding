import java.util.Random;

public class QuickSortStrategy implements SortingStrategy {
    private boolean isRandomized;

    public QuickSortStrategy(boolean isRandomized) {
        this.isRandomized = isRandomized;
    }

    @Override
    public void sort(int[] inputArray) {
        sort(inputArray, "ascending");
    }

    @Override
    public void sort(int[] inputArray, String order) {
        quickSort(inputArray, 0, inputArray.length - 1, order.toLowerCase());
    }

    private void quickSort(int[] arr, int low, int high, String order) {
        if (low < high) {
            int pi = partition(arr, low, high, order);
            quickSort(arr, low, pi - 1, order);
            quickSort(arr, pi + 1, high, order);
        }
    }

    private int partition(int[] arr, int low, int high, String order) {
        if (isRandomized) {
            int randomPivot = new Random().nextInt(high - low) + low;
            swap(arr, randomPivot, high);
        }

        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            boolean condition = order.equals("descending") ? arr[j] > pivot : arr[j] < pivot;
            if (condition) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}