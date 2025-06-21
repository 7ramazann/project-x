class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = n+1;

        Deque<Integer> deq = new ArrayDeque<>();
        long[] B = new long[n+1];
        for(int i = 0; i < n; i++) {
            B[i+1] = B[i] + nums[i];
        }

        // 1 2 -1 2 3        k = 4
        // B: 0 1 3 2 4 7
        
        // deq: 4 5
        // 3-0=2
        // 3 <= 0 

        for(int i = 0; i < B.length; i++) {
            while(!deq.isEmpty() && B[i]-B[deq.peekFirst()] >= k) {
                res = Math.min(res, i - deq.pollFirst());
            }
            
            while(!deq.isEmpty() && B[i] <= B[deq.peekLast()]) {
                deq.pollLast();
            }

            deq.offerLast(i);
        }

        return res <= n ? res : -1;
    }
}
