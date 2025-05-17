class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = n*m;
        int ans = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            // int count = countNumsLessThanOrEqualToValueInMultTableMbyN(mid, m, n);
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(mid/i, n);
            }

            if(count >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private int countNumsLessThanOrEqualToValueInMultTableMbyN(int value, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // Observation: In i-th row, I have (value / i) numbers that are <= value.
            // m=5 x n=6 mult table
            //  ________________  if the mult table would beyond boundaries...
            // |1  2  3  4  5  6| ->  7  8  9 10 11 12 13 14 15 16...
            // |2  4  6  8 10 12| -> 14 16 18 20 22 24 26 28 30 32...
            // |3  6  9 12 15 18| -> 21 24 27 30 33 36 39 42 45 48...
            // |4  8 12 16 20 24| -> 28 32 36 40 44 48 52 56 60 64...
            // |5 10 15 20 25 30| -> 35 40 45 50 55 60 65 70 75 80...
            //  ----------------
            // E.g. in 5x6 mult table
            //   * in 1st row (multiples of 1), you have min(15 / 1, 6) = 6 numbers that are <= 15
            //   * in 2nd row (multiples of 2), you have min(15 / 2, 6) = 6 numbers that are <= 15
            //   * in 3rd row (multiples of 3), you have min(15 / 3, 6) = 5 numbers that are <= 15
            //   * in 4th row (multiples of 4), you have min(15 / 4, 6) = 3 numbers that are <= 15
            //   * in 5th row (multiples of 5), you have min(15 / 5, 6) = 3 numbers that are <= 15
            // In total, there are 6 + 6 + 5 + 3 + 3 = 23 numbers (out of 30) that are <= 15
            count += Math.min(value / i, n);
        }
        return count;
    }
}
