class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> d = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (!d.isEmpty() && d.peekFirst() <= i - k) {
                d.pollFirst();
            }
            while (!d.isEmpty() && nums[i] >= nums[d.peekLast()]) {
                d.pollLast();
            }
            d.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[d.peekFirst()];
            }
        }
        return res;
    }
}
