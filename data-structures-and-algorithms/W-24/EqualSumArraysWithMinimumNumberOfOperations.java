class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6) return -1;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        int diff = sum2 - sum1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num: nums1) {
            if (6 - num > 0) {
                maxHeap.offer(6-num);
            }
        }

        for(int num: nums2) {
            if (num - 1 > 0) {
                maxHeap.offer(num - 1);
            }
        }

        int operations = 0;
        while(diff > 0 && !maxHeap.isEmpty()) {
            diff -= maxHeap.poll();
            operations++;
        }

        return operations;
    }
}
