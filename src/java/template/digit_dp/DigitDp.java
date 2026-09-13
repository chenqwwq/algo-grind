package template.digit_dp;

import java.util.Arrays;

/**
 * 数位 DP(记忆化搜索版)
 * <p>
 * 适用场景:统计 [0, n] 范围内满足某种数字约束的数字个数
 * <p>
 * 核心套路:
 * 1. 把 n 拆成 digits[] 数组(digits[0] 为最高位)
 * 2. 从高位向低位 DFS,枚举每一位可以填的数字
 * 3. 两个关键状态参数:
 *    - limit:当前位是否受 n 的上界约束。受限时该位最多只能填 digits[pos],否则可填 0~9
 *    - lead :此前的位是否全是前导 0。为 true 说明还没出现有效数字(影响"数字 0"的统计、前导零是否参与计算等)
 * 4. 记忆化:只有 (limit == false && lead == false) 的分支才能缓存,受限 / 前导零路径每一条都不相同,缓存无意义
 * <p>
 * 状态维 state 按题目自由扩展:数位和、当前余数、某数字出现次数、是否出现过某数字(二进制 mask)等
 * 想从「计数」改成「求和 / 求第 k 大」时,把 memo 存的值换成对应该题意的结构即可
 *
 * @author chenqwwq
 * @date 2026/08/15
 **/
public class DigitDp {

    /**
     * 例题 1:统计 [1, n] 中不含数字 4 的数字个数
     * 最简骨架,无额外状态,memo 退化成 pos 一维
     */
    public int countWithoutDigit4(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        int[] memo = new int[len];
        Arrays.fill(memo, -1);
        return dfs1(0, true, true, digits, len, memo);
    }

    private int dfs1(int pos, boolean limit, boolean lead, int[] digits, int len, int[] memo) {
        if (pos == len) {
            // 走到最后说明枚举出一个合法数字;lead == true 表示枚举的是 0,题目要求 [1,n] 则排除
            return lead ? 0 : 1;
        }
        // 只缓存通用状态:不受限 && 非全前导零
        if (!limit && !lead && memo[pos] != -1) {
            return memo[pos];
        }

        int up = limit ? digits[pos] : 9;
        int ans = 0;
        for (int d = 0; d <= up; d++) {
            if (d == 4) {
                continue; // 按题目条件剪枝
            }
            ans += dfs1(pos + 1, limit && d == up, lead && d == 0, digits, len, memo);
        }

        if (!limit && !lead) {
            memo[pos] = ans;
        }
        return ans;
    }

    /**
     * 例题 2:统计 [1, n] 中各位数字之和能被 7 整除的数字个数
     * 演示状态维扩展:memo[pos][state],state = 当前数位和 mod 7
     */
    public int countSumDivisibleBy7(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        int[][] memo = new int[len][7];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs2(0, 0, true, true, digits, len, memo);
    }

    private int dfs2(int pos, int state, boolean limit, boolean lead, int[] digits, int len, int[][] memo) {
        if (pos == len) {
            return lead ? 0 : (state == 0 ? 1 : 0);
        }
        if (!limit && !lead && memo[pos][state] != -1) {
            return memo[pos][state];
        }

        int up = limit ? digits[pos] : 9;
        int ans = 0;
        for (int d = 0; d <= up; d++) {
            boolean nextLead = lead && d == 0;
            // 前导零不参与数位和,只在出现有效数字后才累加
            int nextState = nextLead ? 0 : (state + d) % 7;
            ans += dfs2(pos + 1, nextState, limit && d == up, nextLead, digits, len, memo);
        }

        if (!limit && !lead) {
            memo[pos][state] = ans;
        }
        return ans;
    }
}
