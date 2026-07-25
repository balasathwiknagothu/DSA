class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        return 10 + fun(2, n);
    }

    int fun(int digit, int n) {
        if (digit > n || digit > 10) return 0;

        int ways = 9;
        for (int i = 9; i > 9 - (digit - 1); i--) {
            ways *= i;
        }

        return ways + fun(digit + 1, n);
    }
}