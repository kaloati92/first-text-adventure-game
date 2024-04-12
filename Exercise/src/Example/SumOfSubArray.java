package Example;

public class SumOfSubArray {
    public static void main(String[] args) {
        sumOfSubArray(new int[]{51, 6, 22, 66, 1, 12, 34, 31}, 2, 5);
    }

    public static int sumOfSubArray(int[] arr, int i, int j) {
        /* TODO: Implement the method that gets an integer array, a being index and an end index.
            The begin and end index defines a subarray from the original array. Sum the numbers of that subarray.
            i: the begin index, inclusive
            j: the end index, exclusive. */
        // Example: sumOfSubArray({51,6,22,66,1,12, 34, 31}, 2, 5) -> 89
        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += arr[k];
        }
        System.out.println(sum);
        return 0;
    }
}
