class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int l = k - 1;
        int r = n - 1;

        int lSum = 0, rSum = 0;

        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }

        int maxSum = lSum;

        while (l >= 0) {
            lSum -= cardPoints[l];
            rSum += cardPoints[r];
            maxSum = Math.max(maxSum, lSum + rSum);
            l--;
            r--;
        }

        return maxSum;
    }
}