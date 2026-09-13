package top.chenqwwq.leetcode.contest.biweek._188._3;

public class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        final int n = monsters.length;

        int[] ps = new int[n + 1];
        for (int[] boost : boosts) {
            ps[boost[0]] += boost[2];
            ps[boost[1] + 1] -= boost[2];
        }

        long l = 0, r = 0;
        for (int mon : monsters) {
            r += mon;
        }
        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            if (check(mid, monsters, ps)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(long v, int[] monsters, int[] ps) {
        final int n = monsters.length;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += ps[i];
            if (v + cur < monsters[i])
                return false;
            v = Math.max(0, v - monsters[i]);
        }
        return true;
    }

}