package uz.bakhromjon;

import java.util.Arrays;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 13/10/22, Thu, 12:23
 **/
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // O(n * n)
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                }
            }
        }
    }

    // O(n * n)
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int current = nums[i];
            while (j >= 0 && current < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = current;
        }
    }

    // O(n * log(n))
    public static void mergeSort(int[] arr, int len) {
        if (len < 2) {
            return;
        }

        int mid = len / 2;
        int[] left_arr = new int[mid];
        int[] right_arr = new int[len - mid];

        //Dividing array into two and copying into two separate arrays
        int k = 0;
        for (int i = 0; i < len; ++i) {
            if (i < mid) {
                left_arr[i] = arr[i];
            } else {
                right_arr[k] = arr[i];
                k = k + 1;
            }
        }
        // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr, mid);
        mergeSort(right_arr, len - mid);
        // Calling the merge method on each subdivision
        merge(left_arr, right_arr, arr, mid, len - mid);
    }

    public static void merge(int[] left_arr, int[] right_arr, int[] arr, int left_size, int right_size) {
        int i = 0, l = 0, r = 0;
        //The while loops check the conditions for merging
        while (l < left_size && r < right_size) {

            if (left_arr[l] < right_arr[r]) {
                arr[i++] = left_arr[l++];
            } else {
                arr[i++] = right_arr[r++];
            }
        }
        while (l < left_size) {
            arr[i++] = left_arr[l++];
        }
        while (r < right_size) {
            arr[i++] = right_arr[r++];
        }
    }

}
