public class SortHandler {
    private SortingStrategy sortingStrategy;

    // Requirement: Initialize during Object creation
    public SortHandler(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] inputArray) {
        sortingStrategy.sort(inputArray);
    }

    public void sort(int[] inputArray, String order) {
        sortingStrategy.sort(inputArray, order);
    }
}