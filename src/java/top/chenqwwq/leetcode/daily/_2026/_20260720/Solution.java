package top.chenqwwq.leetcode.daily._2026._20260720;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        final int n = grid.length, m = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(m, 0)));
        }

        k %= (n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = (i + ((k + j) / m)) % n;
                int y = (k + j) % m;
                // System.out.printf("%d %d -> %d %d", i, j, x, y);
                ans.get(x).set(y, grid[i][j]);
            }
        }
        return ans;
    }
}