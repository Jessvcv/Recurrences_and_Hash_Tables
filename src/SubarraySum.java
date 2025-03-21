import java.util.*;

public class SubarraySum {
    public static int[] sumTarget(int[] A, int K) {
        int left = 0; //left pointer
        int sum = 0;
        //iterate through the array with the right pointer
        for (int right = 0; right < A.length; right++) {
            sum += A[right]; //expand window by adding rightmost element

            //shrink window from left while sum > k
            while (sum > K) {
                sum -= A[left++];
            }

            //finds if there is a subarray with sum equal to K & returns its indices
            if (sum == K) {
                return new int[]{left, right};
            }
        }

        //no valid subarray was found & returns its indices
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 12)));
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 5)));
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 7)));
        System.out.println(Arrays.toString(sumTarget(new int[]{1, 2, 3, 7, 5}, 11)));
    }
}
