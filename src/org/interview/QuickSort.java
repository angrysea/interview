import java.util.Random;

public class QuickSort {

    private final int[] arr;

    private QuickSort(final int[] arr) {
        this.arr = arr;
    }

    private void swap(final int i, final int j) {
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }

    private int randomBetween(final int left, final int right) {
       return (left + right) / 2; //new Random().nextInt(high - low);
    }

    private void sort(final int left, final int right) {
        if (left >= right) {
            return;
        }
        final int pivot = arr[randomBetween(left, right)];
        final int pi = partition(left, right, pivot);
        sort(left, pi - 1);
        sort(pi, right);
    }

    private int partition(int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void printArray() {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        QuickSort qs = new QuickSort(arr);
        qs.sort(0, arr.length - 1);
        qs.printArray();
    }
}