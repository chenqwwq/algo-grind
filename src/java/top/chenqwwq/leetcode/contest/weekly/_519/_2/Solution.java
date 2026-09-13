package top.chenqwwq.leetcode.contest.weekly._519._2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    /** 回文数生成上界（不含），需覆盖 max(nums) 上方最近的那个回文数 */
    private static final int LIMIT = 2_100_000_000;

    /**
     * 每次操作是 ±2，不改变数值奇偶，所以 num 只能在自己的组里找。
     */
    static final List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();

    private static boolean inited = false;

    public long minOperations(int[] nums) {
        init();
        long ans = 0;
        for (int num : nums) {
            ans += h(num);
        }
        return ans;
    }

    /** 在 num 同奇偶的回文里取最近者，差值折半即操作次数 */
    private long h(int num) {
        return nearestDiff((num & 1) == 1 ? odd : even, num) / 2;
    }

    /** 升序回文列表中与 num 最近的元素，与 num 的差值；num 本身是回文时返回 0 */
    private long nearestDiff(List<Integer> palindromes, int num) {
        int i = Collections.binarySearch(palindromes, num);
        if (i >= 0) return 0;
        i = -i - 1; // 首个 > num 的位置
        long diff = Long.MAX_VALUE;
        if (i < palindromes.size()) diff = (long) palindromes.get(i) - num;                // 向上跨
        if (i > 0) diff = Math.min(diff, (long) num - palindromes.get(i - 1));              // 向下跨
        return diff;
    }

    private static void init() {
        if (inited) return;
        inited = true;
        genPalindromes(LIMIT);
    }

    public static void genPalindromes(int limit) {
        odd.clear();
        even.clear();
        for (int k = 1;; k++) {
            int from = pow10(k - 1), to = pow10(k); // half ∈ [10^(k-1), 10^k)
            if (build(from, true) >= limit && build(from, false) >= limit)
                break; //
            // 两种长度分两趟写：同一 half 交错写入会让 half=1 的 11 排在 half=2 的 3 前面，破坏升序
            for (int half = from; half < to; half++) {
                long o = build(half, true);
                if (o < limit)
                    (o % 2 == 0 ? even : odd).add((int) o);
            }
            for (int half = from; half < to; half++) {
                long e = build(half, false);
                if (e < limit)
                    (e % 2 == 0 ? even : odd).add((int) e);
            }
        }
    }

    /** half 为左半部分（奇数长度时 half 多带一位中心数），镜像出完整回文 */
    private static long build(int half, boolean oddLength) {
        long res = half;
        for (int x = oddLength ? half / 10 : half; x > 0; x /= 10) {
            res = res * 10 + x % 10;
        }
        return res;
    }

    private static int pow10(int k) {
        int r = 1;
        while (k-- > 0)
            r *= 10;
        return r;
    }

    // private long h(int num) {
    // if (num < 10)
    // return 0;
    // StringBuilder sn = new StringBuilder(String.valueOf(num));
    // final int n = sn.length();
    // // 4 0,1 2,3
    // // 5 0,1 3,4
    // int l = sn.charAt(0) - '0', r = sn.charAt(n - 1) - '0';
    // // 首位的奇偶 相同
    // int half = n >> 1;
    // if ((l & 1) == (r & 1)) {
    // // 取左右的数字相减
    // String sl = new StringBuilder(sn.substring(0, half)).reverse().toString();
    // String sr = sn.substring(half + (n & 1));
    // return Math.abs((Long.parseLong(sr) - Long.parseLong(sl))) >> 1;
    // }

    // // 不想等只能跨
    // // 12224
    // //
    // // 124
    // // 231
    // // 191
    // String sl = new StringBuilder(sn.substring(0, half + (n & 1))).toString();
    // Long k = Long.parseLong(sl);
    // if((r & 1) == 1){
    // if(sl.charAt(0) == 1) return
    // }
    // }

    // private String reverse(String s) {
    // return new StringBuilder(s).reverse().toString();
    // }
}
