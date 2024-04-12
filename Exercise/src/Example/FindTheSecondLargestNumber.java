package Example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FindTheSecondLargestNumber {
    public static void main(String[] args) {
        findTheSecondLargestNumber(new int[]{51, 6, 22, 66, 1, 12});
    }

    public static int findTheSecondLargestNumber(int[] arr) {
        // TODO: Implement the method that gets an integer array as input and returns the SECOND largest number from it.
        // Example: findTheSecondLargestNumber({51,6,22,66,1,12}) -> 51
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 2]);
        return 0;
    }
}
