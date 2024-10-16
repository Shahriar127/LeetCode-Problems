import java.util.Arrays;

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
