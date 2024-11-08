import java.util.*;

class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = findBound(nums, target, true);
        if (start == -1) return new int[]{-1, -1};
        int end = findBound(nums, target, false);
        return new int[]{start, end};
    }

    private int findBound(int[] nums, int target, boolean isStart) {
        int low = 0, high = nums.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (isStart) high = mid - 1;
                else low = mid + 1;
            } else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return idx;
    }
}
