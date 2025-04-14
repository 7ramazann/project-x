class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n: nums) {
            set.add(n);
        }

        int streak = 0;
        for(int i: set) {
            if(!set.contains(i-1)) {
                int start = i;
                int end = i;

                while(set.contains(end+1)) {
                    end++;
                }

                streak = Math.max(streak, end - start + 1);
            }
        }
        return streak;
    }
}
