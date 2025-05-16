class Solution {
    public int findMin(int[] nums) {
        // [6,7,0,1,2,4,5]

        int left = 0;
        int right = nums.length-1;
        int ans = 0;

        if (nums.length == 1) return nums[0];

        if (nums[0] < nums[nums.length - 1]) return nums[0];

        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
