package top.chenqwwq.leetcode.contest.biweek._188._2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumWidth(int[] planks) {
        // 统计 planks 的元素出现次数
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : planks) {
            cnt.merge(x, 1, Integer::sum); // cnt[x]++
        }

        // 枚举所有高度对 (x,y)
        HashMap<Integer, Integer> cntPair = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int x = e.getKey();
            int c = e.getValue();
            cntPair.merge(x, c, Integer::sum); // 方便最后算 max
            cntPair.merge(x * 2, c / 2, Integer::sum); // 高为 x 的木板内部配对
            for (Map.Entry<Integer, Integer> e2 : cnt.entrySet()) {
                int y = e2.getKey();
                int c2 = e2.getValue();
                if (y > x) { // 避免 x+y 和 y+x 重复统计
                    cntPair.merge(x + y, Math.min(c, c2), Integer::sum);
                }
            }
        }

        // 枚举栅栏高度
        return Collections.max(cntPair.values());
    }
}
