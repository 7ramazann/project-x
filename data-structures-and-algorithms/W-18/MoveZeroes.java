class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int n: nums) {
            if (n != 0) {
                nums[pos++] = n;
            }
        }

        while (pos != nums.length) {
            nums[pos++] = 0;
        }

        // 0 1 0 3 12

        // 1 0 0 3 12
        // 1 3 0 0 12
    }

    public int[] swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = nums[temp];
        return nums;
    }
}
