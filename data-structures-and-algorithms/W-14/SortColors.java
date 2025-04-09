class Solution {
    public void sortColors(int[] nums) {
        int zeroPos = 0;
        int twoPos = nums.length -1;
        int i = 0;

        while(i<=twoPos) {
            if(nums[i]==0) {
                swap(nums, zeroPos, i);
                zeroPos++;
                i++;
            } else if(nums[i]==1) {
                i++;
            } else {
                swap(nums, i, twoPos);
                twoPos--;
            }
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
