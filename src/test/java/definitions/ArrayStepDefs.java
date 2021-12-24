package definitions;

import io.cucumber.java.en.Then;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayStepDefs {

    public static boolean containsDuplicates1(int[] arr) {
        if (arr != null) {
            Set<Integer> set = new HashSet<>();
            for (int j : arr) {
                if (!set.add(j)) return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicates2(int[] arr) {
        if (arr == null) return false;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }

    @Then("run test cases for all implementations of containsDuplicates method")
    public void runTestCasesForContainsDuplicates() {
        List<Predicate<int[]>> containsDuplicatesList =
                new ArrayList<>(Arrays.asList(ArrayStepDefs::containsDuplicates1,ArrayStepDefs::containsDuplicates2));
        for (Predicate<int[]> containsDuplicates : containsDuplicatesList) {
            assertThat(containsDuplicates.test(new int[]{-1, 0, 1})).isFalse();
            assertThat(containsDuplicates.test(new int[]{1, 100, 2, 1, 4})).isTrue();
            assertThat(containsDuplicates.test(new int[]{-1, -1, 0, 0, 1, 1})).isTrue();
            assertThat(containsDuplicates.test(new int[]{})).isFalse();
            assertThat(containsDuplicates.test(null)).isFalse();
        }

    }

    public static List<Integer> findDuplicates1(int[] arr) {
        if (arr == null) return new ArrayList<>();
        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        // List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set <Integer> set = new HashSet<>(list);
        Collections.reverse(list);
        set.forEach(list::remove);
        Collections.reverse(list);
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static List<Integer> findDuplicates2(int[] arr) {
        List<Integer> list = new LinkedList<>();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) list.add(arr[i]);
                }
            }
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    private static boolean contains(int[] arr, int n, int start, int end) {
        for (int i=start; i<end; i++) {
            if (arr[i] == n) return true;
        }
        return false;
    }

    public static int[] findDuplicates3(int[] arr) {
        if (arr == null) return new int[]{};
        int[] temp = new int[arr.length/2];
        int l = 0;
        for (int i=0; i<arr.length; i++) {
            if (contains(arr,arr[i],i+1,arr.length) && !contains(temp,arr[i],0,l)) {
                temp[l] = arr[i];
                l++;
            }
        }
        int[] result = new int[l];
        // for (int i=0; i<l; i++) { result[i] = temp[i]; }
        System.arraycopy(temp, 0, result, 0, l);
        return result;
    }

    public static <T> List<T> findDuplicates1(T[] str_arr) {
        if (str_arr == null) return new ArrayList<>();
        List<T> list = new ArrayList<>(Arrays.asList(str_arr));
        for (T str : str_arr) {
            if (Collections.frequency(list,str) == 1) list.remove(str);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    @Then("run test cases for all implementations of findDuplicates method")
    public void runTestCasesForFindDuplicates() {
        List<Function<int[],List<Integer>>> findDuplicatesList =
                         new ArrayList<>(Arrays.asList(ArrayStepDefs::findDuplicates1,ArrayStepDefs::findDuplicates2));
        for (Function<int[],List<Integer>> findDuplicates : findDuplicatesList) {
            assertThat(findDuplicates.apply(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}))
                                                                             .isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
            assertThat(findDuplicates.apply(new int[]{0, -3, -3, 7, 0, 1, 4, 9})).isEqualTo(Arrays.asList(0, -3));
            assertThat(findDuplicates.apply(new int[]{1, 6, -3, 7, 2, 1, 4, 9})).isEqualTo(List.of(1));
            assertThat(findDuplicates.apply(new int[]{1, 1})).isEqualTo(List.of(1));
            assertThat(findDuplicates.apply(new int[]{1, 1, 1, 1})).isEqualTo(List.of(1));
            assertThat(findDuplicates.apply(new int[]{1, 2, 3, 4, 5})).isEqualTo(List.of());
            assertThat(findDuplicates.apply(new int[]{})).isEqualTo(List.of());
            assertThat(findDuplicates.apply(null)).isEqualTo(List.of()); // List.of from Java 9
        }

        Function<int[],int[]> findDuplicates_ = ArrayStepDefs::findDuplicates3;
        assertThat(findDuplicates_.apply(new int[]{1,2,3,4,5,5,4,3,2,1})).isEqualTo(new int[]{1,2,3,4,5});
        assertThat(findDuplicates_.apply(new int[]{0,-3,-3,7,0,1,4,9})).isEqualTo(new int[]{0,-3});
        assertThat(findDuplicates_.apply(new int[]{1,6,-3,7,2,1,4,9})).isEqualTo(new int[]{1});
        assertThat(findDuplicates_.apply(new int[]{1,1})).isEqualTo(new int[]{1});
        assertThat(findDuplicates_.apply(new int[]{1,1,1,1})).isEqualTo(new int[]{1});
        assertThat(findDuplicates_.apply(new int[]{1,2,3,4,5})).isEqualTo(new int[]{});
        assertThat(findDuplicates_.apply(new int[]{})).isEqualTo(new int[]{});
        assertThat(findDuplicates_.apply(null)).isEqualTo(new int[]{});

        Function<String[],List<String>> findDuplicates1 = ArrayStepDefs::findDuplicates1; // overloaded
        assertThat(findDuplicates1.apply(new String[]{"test", "taste", "test"})).isEqualTo(List.of("test"));
        assertThat(findDuplicates1.apply(new String[]{"one"})).isEqualTo(List.of());
        assertThat(findDuplicates1.apply(new String[]{"hello","hello","hello"})).isEqualTo(List.of("hello"));
        assertThat(findDuplicates1.apply(new String[]{"one","two","two","one"})).isEqualTo(Arrays.asList("one","two"));
        assertThat(findDuplicates1.apply(new String[]{"public","protected","default","private","","","private"}))
                .isEqualTo(Arrays.asList("private",""));
        assertThat(findDuplicates1.apply(new String[]{})).isEqualTo(List.of());
        assertThat(findDuplicates1.apply(new String[]{null})).isEqualTo(List.of());
        assertThat(findDuplicates1.apply(new String[]{null,null})).isEqualTo(Arrays.asList((String) null));
        assertThat(findDuplicates1.apply(new String[]{"branch",null,"branch", null}))
                .isEqualTo(Arrays.asList("branch",null));
        assertThat(findDuplicates1.apply(null)).isEqualTo(List.of());
    }

    public static List<Integer> twoLargest(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if ((arr != null) && (arr.length != 0)) {
            int firstMax = arr[0];
            if (arr.length != 1) {
                int secondMax;
                if (firstMax > arr[1]) {
                    secondMax = arr[1];
                } else {
                    secondMax = firstMax;
                    firstMax = arr[1];
                }
                for (int i=2; i<arr.length; i++) {
                    if (arr[i] > firstMax) {
                        secondMax = firstMax;
                        firstMax = arr[i];
                    } else {
                        if (arr[i] > secondMax) {
                            secondMax = arr[i];
                        }
                    }
                }
                list.add(secondMax);
            }
            list.add(firstMax);
        }
        return list;
    }

    public static List<Integer> twoLargest2(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if ((arr != null) && (arr.length != 0)) {
            int firstMax = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            // replaceable with enhanced 'for' loop
            for (int i=0; i<arr.length; i++) {
                if (arr[i] > firstMax) {
                    secondMax = firstMax;
                    firstMax = arr[i];
                } else if (arr[i] > secondMax) {
                    secondMax = arr[i];
                }
            }
            if (arr.length > 1) list.add(secondMax);
            list.add(firstMax);
        }
        return list;
    }

    public static List<Integer> twoLargest3(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if ((arr != null) && (arr.length != 0)) {
            List<Integer> inputList = Arrays.stream(arr).boxed().collect(Collectors.toList());
            Integer firstMax = Collections.max(inputList);
            list.add(firstMax);
            inputList.remove(firstMax);
            if (!inputList.isEmpty()) list.add(0,Collections.max(inputList));
        }
        return list;
    }

    public static List<Integer> twoLargest4Adapter(int[] arr) {
        int[] resArr;
        if (arr == null) {
            resArr = twoLargest4(null);
        } else {
            resArr = twoLargest4(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        return Arrays.stream(resArr).boxed().collect(Collectors.toList());
    }

    public static int[] twoLargest4(List<Integer> list) {
        if ((list == null) || list.isEmpty()) return new int[]{};
        int[] arr;
        if (list.size() == 1) {
            arr = new int[1];
            arr[0] = list.get(0);
            return arr;
        }
        list.sort(Comparator.reverseOrder()); // if unique elements should be returned: Set set = new TreeSet(list);
        arr = new int[2];
        arr[0] = list.get(1);
        arr[1] = list.get(0);
        return arr;
    }

    public static boolean twoResultInSum(List<Integer> list, int sum) {
        if ((list == null) || list.isEmpty() || (list.size() == 1)) return false;
        list.sort(Comparator.naturalOrder());
        int left = 0;
        int right = list.size() - 1;
        int curSum;
        while (left != right) {
            curSum = list.get(left) + list.get(right);
            if (curSum == sum) {
                return true;
            } else if (curSum < sum) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return false;
    }

    @Then("run test cases for twoResultInSum method")
    public void runTestCasesForResultInSum() {
        assertThat(twoResultInSum(null, 0)).isFalse();
        assertThat(twoResultInSum(List.of(), 0)).isFalse();
        assertThat(twoResultInSum(Arrays.asList(10), 10)).isFalse();
        assertThat(twoResultInSum(Arrays.asList(1,1), 2)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(0,0), 0)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(0,10), 10)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(1,5,-3,8,-2,35,12,10,0), 1)).isTrue(); // on the sides not sorted
        assertThat(twoResultInSum(Arrays.asList(5,-3,8,7,3,-2,-9,35,12,10), 1)).isTrue(); // in the middle not sorted
        assertThat(twoResultInSum(Arrays.asList(-3,-2,0,5,9,11,34), 31)).isTrue(); // on the sides sorted
        assertThat(twoResultInSum(Arrays.asList(0,5,-3,-2,5,34,9,11), 31)).isTrue(); // on the sides after sort
        assertThat(twoResultInSum(Arrays.asList(1,5,-3,8,-2,35,12,10,0), 12)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(-3,3,7,7), 0)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(Integer.MAX_VALUE,1),Integer.MIN_VALUE)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(Integer.MAX_VALUE/2,Integer.MAX_VALUE/2+1), Integer.MAX_VALUE)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(-Integer.MIN_VALUE/2,-Integer.MIN_VALUE/2), -Integer.MIN_VALUE)).isTrue();
        assertThat(twoResultInSum(Arrays.asList(-Integer.MIN_VALUE,-Integer.MIN_VALUE), -Integer.MIN_VALUE)).isFalse();
    }

    @Then("run test cases for all implementations of twoLargest method")
    public void runTestCasesForTwoLargest() {
        new ArrayList<Function<int[],List<Integer>>>(Arrays.asList(ArrayStepDefs::twoLargest,
          ArrayStepDefs::twoLargest2, ArrayStepDefs::twoLargest3, ArrayStepDefs::twoLargest4Adapter))
          .forEach(twoLargest -> {
            assertThat(twoLargest.apply(null)).isEqualTo(List.of());
            assertThat(twoLargest.apply(new int[]{})).isEqualTo(List.of());
            assertThat(twoLargest.apply(new int[]{1})).isEqualTo(List.of(1));
            assertThat(twoLargest.apply(new int[]{-100})).isEqualTo(List.of(-100));
            assertThat(twoLargest.apply(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}))
                    .isEqualTo(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE));
            assertThat(twoLargest.apply(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE}))
                    .isEqualTo(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));
            assertThat(twoLargest.apply(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 456, -2345}))
                    .isEqualTo(Arrays.asList(0, 456));
            assertThat(twoLargest.apply(new int[]{0, 0})).isEqualTo(Arrays.asList(0, 0));
            assertThat(twoLargest.apply(new int[]{-1, 1})).isEqualTo(Arrays.asList(-1, 1));
            assertThat(twoLargest.apply(new int[]{1, 2, 3, 4, 5})).isEqualTo(Arrays.asList(4, 5));
            // first element is first largest, second element is second largest
            assertThat(twoLargest.apply(new int[]{5, 4, 3, 2, 1})).isEqualTo(Arrays.asList(4, 5));
            // first element is second largest, second element is first largest
            assertThat(twoLargest.apply(new int[]{4, 5, 3, 2, 1})).isEqualTo(Arrays.asList(4, 5));
            // first element is not in return list, second element is second largest
            assertThat(twoLargest.apply(new int[]{1, 4, 3, 5, 1})).isEqualTo(Arrays.asList(4, 5));
            // first and second elements are not in return list
            assertThat(twoLargest.apply(new int[]{3, 2, 4, 5, 1})).isEqualTo(Arrays.asList(4, 5));
            // first element is not on return list, second element is second largest, value are negative
            assertThat(twoLargest.apply(new int[]{-3, -2, -4, -5, -1})).isEqualTo(Arrays.asList(-2, -1));
            // positive and negative values, duplicate values
            assertThat(twoLargest.apply(new int[]{50, -1000, 50, -200, 300, 20})).isEqualTo(Arrays.asList(50, 300));
        });
    }
}
