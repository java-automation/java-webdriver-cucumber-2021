package definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingStepDefs {

    @Then("array {int_array} sorted by method {string} should match {int_array}")
    public void arraySortedByFunctionShouldMatch(int[] arr_to_sort, String sorting_method, int[] expected_arr) throws Exception {
        System.out.println("Input array: " + Arrays.toString(arr_to_sort));
        Method methodToExecute = SortingStepDefs.class.getDeclaredMethod(sorting_method, int[].class);
        methodToExecute.invoke(new SortingStepDefs(), (Object) arr_to_sort);
        Assert.assertArrayEquals(expected_arr,arr_to_sort);
        System.out.println("Sorted array: " + Arrays.toString(arr_to_sort));
    }

    public static void sortIfOdd4(int[] arr) {
        // iterator for sorted set of odd values in arr
        Iterator<Integer> iterator = Arrays.stream(arr).filter(item -> Math.abs(item % 2) == 1).sorted().iterator();
        // searching for indices of odd values in arr and placing sorted set into those places
        IntStream.range(0, arr.length).filter(i -> Math.abs(arr[i] % 2) == 1).forEach(i -> arr[i] = iterator.next());
    }

    public static void sortIfOdd3(int[] arr) {
        Iterator<Integer> iterator = Arrays.stream(arr).filter(item -> Math.abs(item % 2) == 1).sorted().iterator();
        for (int i : IntStream.range(0, arr.length).filter(i -> Math.abs(arr[i] % 2) == 1).toArray()) {
            if (iterator.hasNext()) arr[i] = iterator.next();
        }

//        for (int i=0; i<arr.length; i++) {
//            while (Math.abs(arr[i] % 2) != 1) { i++; }
//            arr[i] = iterator.next();
//        }

//        for (int i=0; i<arr.length; i++) {
//            if (Math.abs(arr[i] % 2) == 1) {
//                arr[i] = iterator.next();
//            }
//        }
    }

    public static void sortIfOdd2(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> sorted_list = list.stream().filter(item -> Math.abs(item % 2) == 1).sorted().toList();
        int j = 0;
        for (int i : IntStream.range(0, arr.length).filter(i -> Math.abs(arr[i] % 2) == 1).toArray()) {
            arr[i] = sorted_list.get(j);
            j++;
        }
    }

    public static List<Integer> filtered_indices(int[] arr) {
        List<Integer> indices = new ArrayList<Integer>();
        if (arr == null || arr.length == 0) return indices;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] % 2) == 1) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void sortIfOdd(int[] arr) {
        List<Integer> indices = filtered_indices(arr);
        if (indices.size() < 2) return;
        int temp, n, m;
        for (int end = indices.size(); end > 1; end--) {
            for (int i = 0; i < end - 1; i++) {
                n = indices.get(i);
                m = indices.get(i + 1);
                if (arr[n] > arr[m]) {
                    temp = arr[n];
                    arr[n] = arr[m];
                    arr[m] = temp;
                }
            }
        }
    }

    // mergesort of some sort
    // was trying to fit everything into one recursive function, but had to create multiple array to hold sorted
    // segments instead of one helper array as it is done in classical implementation
    // LEAVING JUST FOR TESTING (inefficient use of space and therefore too verbose)
    public static int[] myMergeSort(int[] arr, int start, int end) {
        if (start > end) return new int[]{};
        if (start == end) {
            //System.out.println("[" + arr[start] + "]" + " " + start + " " + end);
            return new int[]{arr[start]};
        }
        int mid = start + (end - start) / 2;
        int[] arr_half1 = myMergeSort(arr, start, mid);
        int[] arr_half2 = myMergeSort(arr, mid + 1, end);
        int i = 0;
        int j = 0;
        int n = start;
        while (i < arr_half1.length && j < arr_half2.length) {
            if (arr_half1[i] > arr_half2[j]) {
                arr[n] = arr_half2[j];
                j++;
            } else {
                arr[n] = arr_half1[i];
                i++;
            }
            n++;
        }
        while (i < arr_half1.length && j == arr_half2.length) {
            arr[n] = arr_half1[i];
            i++;
            n++;
        }
        /* this might be ommited since arr_half2 was already present in the arr
        while (j<arr_half2.length && i==arr_half1.length) {
            arr[n]=arr_half2[j];
            j++;
            n++;
        }
        */
        //System.out.println(Arrays.toString(arr));
        int[] new_arr = new int[end - start + 1];
        int index = 0;
        for (int m = start; m < end + 1; m++) {
            new_arr[index] = arr[m];
            index++;
        }
        //System.out.println(Arrays.toString(new_arr) + " " + start + " " + end);
        return new_arr;
    }

    // mergesort - divide and conquer comparison sort algorithm
    public static void mergeSort(int[] arr) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] helper, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(arr, helper, start, middle);
            mergeSort(arr, helper, middle + 1, end);
            merge(arr, helper, start, middle, end);
        }
    }

    // The merge method operates by copying all the elements from two already sorted segments from
    // target array to a helper array and then returning those elements back in the right order.
    public static void merge(int[] arr, int[] helper, int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            helper[i] = arr[i];
        }
        int leftHalfIndex = start;
        int rightHalfIndex = middle + 1;
        int current = start;
        while ((leftHalfIndex <= middle) && (rightHalfIndex <= end)) {
            if (helper[leftHalfIndex] > helper[rightHalfIndex]) {
                arr[current] = helper[rightHalfIndex];
                rightHalfIndex++;
            } else {
                arr[current] = helper[leftHalfIndex];
                leftHalfIndex++;
            }
            current++;
        }
        for (int k = leftHalfIndex; k <= middle; k++) {
            arr[current] = helper[k];
            current++;
        }
    }

    public static void mergeSortOddElements(int[] arr) {
        int[] odd_arr = Arrays.stream(arr).filter(item -> Math.abs(item % 2) == 1).toArray();
        mergeSort(odd_arr);
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] % 2) == 1) {
                arr[i] = odd_arr[j];
                j++;
            }
        }
    }

    // Quicksort sorts an array in place, no need for extra space other than
    // the original space occupied by an array and for swaps. (Also called: partition-exchange sort)
    // Time complexity: The number of times we can break it in half will be the base-2 logarithm of the number of inputs.
    // We have log(N) partitioning "levels", and each level has to visit all N inputs. => N*log(N)
    // Worst time complexity: O(N^2) when partitioning unluckily happens around min or max elements.
    public static void quickSort(int[] arr, int start, int end) {
        // based on https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/visualize/
        if (start < end) {
            int index = partition(arr, start, end);
            quickSort(arr, start, index - 1);
            quickSort(arr, index + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        // Select the pivot.
        int pivot = arr[start + (end - start) / 2];
        // Move the pivot to the end.
        swap(arr, start + (end - start) / 2, end);
        // Partition the subarray.
        int left = start;
        int right = end - 1;
        while (left <= right) {
            // Move the left bound to the right until it reaches a value greater than or equal to the pivot.
            while (arr[left] < pivot) {
                left++;
            }
            // Move the right bound to the left until it crosses the left bound or finds a value less than the pivot.
            while ((right >= 0) && (pivot <= arr[right])) {
                right--;
            }
            // Swap the selected values.
            if (left <= right) {
                swap(arr, left, right);
            }
        }
        // When the right bound crosses the left bound, all elements to the left of the left bound
        // are less than the pivot and all elements to the right are greater than or equal to the pivot.
        swap(arr, left, end);
        return left;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Limiting sorting to only odd values happens by having an array of indices of such values and moving
    // left and right pointers over this array instead of the original array.
    // Note that boundary parameters for ranges are inclusive on both sides to fit recursive approach.
    // Alternative not-taken paths:
    // Checks of evenness could have been made throughout the sorting steps to skip those values in considerations.
    // Actual odd values could have been copied to a separate array, sorted and put back.
    public static void quickSortOddElements(int[] arr) {
        int[] indices = IntStream.range(0, arr.length).filter(i -> Math.abs(arr[i] % 2) == 1).toArray();
        quickSortSelectElements(arr, indices, 0, indices.length - 1);
    }

    public static void quickSortSelectElements(int[] arr, int[] indices, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int index = partitionSelectElements(arr, indices, startIdx, endIdx);
            quickSortSelectElements(arr, indices, startIdx, index - 1);
            quickSortSelectElements(arr, indices, index + 1, endIdx);
        }
    }

    public static int partitionSelectElements(int[] arr, int[] indices, int startIdx, int endIdx) {
        int middleIdx = startIdx + (endIdx - startIdx) / 2;
        int pivot = arr[indices[middleIdx]];
        // Move the pivot to the end.
        swap(arr, indices[middleIdx], indices[endIdx]);
        // Partition the subarray (using positions in indices array).
        int leftIdx = startIdx;
        int rightIdx = endIdx - 1;
        while (leftIdx <= rightIdx) {
            // Move the left bound to the right until it reaches a value greater than or equal to the pivot.
            while (arr[indices[leftIdx]] < pivot) {
                leftIdx++;
            }
            // Move the right bound to the left until it crosses the left bound or finds a value less than the pivot.
            while ((rightIdx >= 0) && (pivot <= arr[indices[rightIdx]])) {
                rightIdx--;
            }
            // Swap the selected values.
            if (leftIdx <= rightIdx) {
                swap(arr, indices[leftIdx], indices[rightIdx]);
            }
        }
        // When the right bound crosses the left bound, all elements to the left of the left bound
        // are less than the pivot and all elements to the right are greater than or equal to the pivot.
        swap(arr, indices[leftIdx], indices[endIdx]);
        return leftIdx;
    }
}
