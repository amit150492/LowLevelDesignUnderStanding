public class MergeSortStrategy implements SortingStrategy {
    private boolean isInPlace;

    public MergeSortStrategy(boolean isInPlace) {
        this.isInPlace = isInPlace;
    }

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1, "asc");
    }

    @Override
    public void sort(int[] array, String order) {
        mergeSort(array, 0, array.length - 1, order.toLowerCase());
    }

    private void mergeSort(int[] arr, int l, int r, String order) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m, order);
            mergeSort(arr, m + 1, r, order);

            if (isInPlace) {
                mergeInPlace(arr, l, m, r, order);
            } else {
                // Standard merge with auxiliary arrays would go here
                System.out.println("Standard Merge not implemented in this snippet.");
            }
        }
    }

    private void mergeInPlace(int[] arr, int start, int mid, int end, String order) {
        int start2 = mid + 1;

        // If the direct boundary is already sorted, no need to merge
        if (compare(arr[mid], arr[start2], order)) {
            return;
        }

        while (start <= mid && start2 <= end) {
            // Check if element 1 is in right place
            if (compare(arr[start], arr[start2], order)) {
                start++;
            } else {
                int value = arr[start2];
                int index = start2;

                // Shift all elements between element 1 and element 2 right by 1
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;

                // Update pointers
                start++;
                mid++;
                start2++;
            }
        }
    }

    private boolean compare(int a, int b, String order) {
        return order.equals("asc") ? (a <= b) : (a >= b);
    }
}