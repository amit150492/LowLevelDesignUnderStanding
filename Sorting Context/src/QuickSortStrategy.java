import java.util.Random;

public class QuickSortStrategy implements SortingStrategy {
    private boolean isRandomized;

    public QuickSortStrategy(boolean isRandomized) {
        this.isRandomized = isRandomized;
    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1, "asc");
    }

    @Override
    public void sort(int[] array, String order) {
        quickSort(array, 0, array.length - 1, order.toLowerCase());
    }

    private void quickSort(int[] arr, int low, int high, String order) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, order);
            quickSort(arr, low, pivotIndex - 1, order);
            quickSort(arr, pivotIndex + 1, high, order);
        }
    }

    private int partition(int[] arr, int low, int high, String order) {
        if (isRandomized) {
            randomizePivot(arr, low, high);
        }

        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // Logic for Ascending vs Descending
            boolean condition = order.equals("asc") ? (arr[j] <= pivot) : (arr[j] >= pivot);

            if (condition) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void randomizePivot(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low) + low;
        swap(arr, pivotIndex, high); // Move random pivot to end
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}