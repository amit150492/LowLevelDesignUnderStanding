public class MergeSortStrategy implements SortingStrategy {
    private boolean isInPlace;

    public MergeSortStrategy(boolean isInPlace) {
        this.isInPlace = isInPlace;
    }

    @Override
    public void sort(int[] inputArray) {
        sort(inputArray, "ascending");
    }

    @Override
    public void sort(int[] inputArray, String order) {
        mergeSort(inputArray, 0, inputArray.length - 1, order.toLowerCase());
    }

    private void mergeSort(int[] arr, int l, int r, String order) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m, order);
            mergeSort(arr, m + 1, r, order);

            if (isInPlace) {
                mergeInPlace(arr, l, m, r, order);
            } else {
                mergeNormal(arr, l, m, r, order);
            }
        }
    }

    // O(1) Space - In-place merge via shifting
    private void mergeInPlace(int[] arr, int start, int mid, int end, String order) {
        int start2 = mid + 1;
        while (start <= mid && start2 <= end) {
            boolean condition = order.equals("descending") ? arr[start] >= arr[start2] : arr[start] <= arr[start2];
            if (condition) {
                start++;
            } else {
                int value = arr[start2];
                int index = start2;
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;
                start++; mid++; start2++;
            }
        }
    }

    // O(N) Space - Standard merge
    private void mergeNormal(int[] arr, int l, int m, int r, String order) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            boolean condition = order.equals("descending") ? L[i] >= R[j] : L[i] <= R[j];
            arr[k++] = condition ? L[i++] : R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}