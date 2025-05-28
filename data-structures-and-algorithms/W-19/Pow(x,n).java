class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        return recursion(x, n);
    }

    public double recursion(double x, int pow) {
        if (pow == 0) return 1;

        return (pow % 2 == 0) ? recursion(x*x, pow/2) : recursion(x*x, pow/2)*x;
    }
}
