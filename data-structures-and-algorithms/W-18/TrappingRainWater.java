class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int ans = 0;

        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        // [ 0 1 1 2 2 2 2 3 3 3 3 3 ]

        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        } 
        // [ 3 3 3 3 3 3 3 3 2 2 2 1 ]

        for (int i = 1; i <= n-2; i++) {
            int limit = Math.min(rightMax[i], leftMax[i]);
            if (limit > height[i]) {
                ans += limit - height[i];
            }
        }
        return ans;
    }
}
