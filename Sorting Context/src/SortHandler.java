public class SortHandler {
    private SortingStrategy sortingStrategy;

    // Constructor handles the "Pluggable" requirement
    public SortHandler(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] array) {
        sortingStrategy.sort(array);
    }

    public void sort(int[] array, String order) {
        sortingStrategy.sort(array, order);
    }
}