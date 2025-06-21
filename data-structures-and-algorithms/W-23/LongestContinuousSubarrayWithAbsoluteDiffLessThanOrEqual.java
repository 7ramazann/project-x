class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int left = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while(!max.isEmpty() && nums[i] > max.peekLast()) {
                max.pollLast();
            }
            while(!min.isEmpty() && nums[i] < min.peekLast()) {
                min.pollLast();
            }
            
            max.offerLast(nums[i]);
            min.offerLast(nums[i]);

            while (max.peekFirst() - min.peekFirst() > limit) {
                if(max.peekFirst() == nums[left]) max.pollFirst();
                if(min.peekFirst() == nums[left]) min.pollFirst();
                left++;
            }

            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
