class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i = 0; i < heights.length; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                ans = Math.max(ans, height * width);
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int height = heights[st.pop()];
            int width = st.isEmpty() ? heights.length : heights.length - st.peek() - 1;
            ans = Math.max(ans, height * width);
        }
        return ans;
    }
}
