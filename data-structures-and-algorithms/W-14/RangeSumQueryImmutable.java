class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        int n = nums.length;

        prefix = new int[n+1];
        prefix[0] = 0;
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right+1] - prefix[left];
    }
}

