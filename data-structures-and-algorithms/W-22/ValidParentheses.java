class Solution {
    public boolean isValid(String s) {
        // (
        // {
        // [
          //stack  (
          // ((][]{}
          // ))((
          // (([

        Stack<Character> stack = new Stack<>();

        for(char el: s.toCharArray()) {
            if (el == '(' || el == '[' || el == '{') {
                stack.push(el);
            }
            if (stack.isEmpty()) return false;
            char last = stack.peek();
            if (el == ')') {
                if (last == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (el == '}') {
                if (last == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (el == ']') {
                if (last == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }
}
