class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        backtrack(ans, 0, 0, "", n);
        return ans;
    }

    public void backtrack(List<String> ans, int left, int right, String s, int n) {
        if(s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if (left < n) {
            backtrack(ans, left + 1, right, s+"(", n);
        }

        if (right < left) {
            backtrack(ans, left, right + 1, s+")", n);
        }
    }
}
