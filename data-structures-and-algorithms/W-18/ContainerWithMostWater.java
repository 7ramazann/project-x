class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int answer = 0;

        while(l < r) {
            int width = r-l;
            int h = Math.min(height[l], height[r]);
            int volume = width * h;
            answer = Math.max(answer, volume);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return answer;
    }
}
