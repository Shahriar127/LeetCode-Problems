import java.util.Arrays;

//Time Complexity O(n^2) 
//using DP

class LIS {
    static int calculateLIS(int[] arr) {
        int n = arr.length;
        
        // Handle empty array case
        if (n == 0) return 0;

        // dp[i] will store the length of the LIS ending at index i
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize dp array to 1 for each element

        // Variable to track the overall maximum LIS length
        int maxLength = 1;

        // Build the dp array
        for (int currentIndex = 1; currentIndex < n; currentIndex++) {
            for (int previousIndex = 0; previousIndex < currentIndex; previousIndex++) {
                if (arr[currentIndex] > arr[previousIndex]) {
                    dp[currentIndex] = Math.max(dp[currentIndex], dp[previousIndex] + 1);
                }
            }
            // Update the maximum LIS length found so far
            maxLength = Math.max(maxLength, dp[currentIndex]);
        }

        return maxLength;
    }

    static void printLISLength(int length) {
        System.out.println("Length of LIS is " + length);
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        int lengthOfLIS = calculateLIS(arr);
        printLISLength(lengthOfLIS);
    }
}


//Time Complexity O(nlog(n))
//using DP + Binary Search

class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;

        // Handle empty array case
        if (n == 0) return 0;

        // This array will store the smallest tail for all increasing subsequences
        int[] tails = new int[n];
        int length = 0; // Length of the longest increasing subsequence

        for (int num : arr) {
            // Binary search for the insertion point
            int left = 0, right = length;

            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1; // Move to the right half
                } else {
                    right = mid; // Move to the left half
                }
            }

            // Update the tails array
            tails[left] = num;

            // If we have a new largest subsequence, increase the length
            if (left == length) {
                length++;
            }
        }

        return length;
    }
}
