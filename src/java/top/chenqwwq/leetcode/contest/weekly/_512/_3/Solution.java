package top.chenqwwq.leetcode.contest.weekly._512._3;

class Solution {
    static final int MOD = 1000000007;

    public int countValidSequences(int n, int k) {
        if (k > n) {
            return 0;
        }

        long ans = c(n - 1L, k - 1);

        if ((n - k) % 2 == 0) {
            long x = (n + (long) k - 2) / 2;
            ans = (ans - c(x, k - 1) + MOD) % MOD;
        }

        return (int) ans;
    }

    private long c(long n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }

        long r = Math.min(k, n - k);
        long a = 1, b = 1;

        for (long i = 1; i <= r; i++) {
            a = a * ((n - r + i) % MOD) % MOD;
            b = b * i % MOD;
        }

        return a * pow(b, MOD - 2) % MOD;
    }

    private long pow(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }

        return ans;
    }
}
