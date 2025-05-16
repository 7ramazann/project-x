class Solution {
    public int shipWithinDays(int[] weights, int days) {
     int left = 0;
     int right = 0;
     int ans = 0;

     // weights = [1,2,3,4,5,6,7,8,9,10]
     // days = 5

     // left: 10
     // right: 55

     for (int w: weights) {
        left = Math.max(left, w); //The minimum capacity must be at least the maximum weight in the array
        right += w; // The maximum capacity can be the sum of all weights
     }

     // mid: 65/2 = 32

     while(left <= right) {
        int mid = (left + right)/2;

        int requiredDays = 1;
        int currentLoad = 0;

            // Simulate how many days are needed with this capacity
            for (int w : weights) {
                if (currentLoad + w > mid) {
                    requiredDays++;
                    currentLoad = w;
                } else {
                    currentLoad += w;
                }
            }

            if (requiredDays > days) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid-1;                
            }
     }

     return ans;


    }
}
