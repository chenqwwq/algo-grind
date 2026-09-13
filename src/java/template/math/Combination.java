package template.math;

/**
 * 组合数工具类。
 *
 * <p>用于计算从 {@code n} 个元素中选择 {@code m} 个元素的方案数：
 * {@code C(n, m) = n! / (m! * (n - m)!)}。</p>
 *
 * <p>当前实现通过费马小定理求分母的模逆元，因此模数必须是质数。</p>
 */
public final class Combination {

    /**
     * 计算组合数 {@code C(n, k) % mod}。
     *
     * <p>根据组合数的对称性，将 {@code k} 缩小为
     * {@code min(k, n - k)}，再分别计算乘法公式的分子和分母：</p>
     *
     * <pre>
     * C(n, k) = (n - r + 1) * ... * n / r!
     * r = min(k, n - k)
     * </pre>
     *
     * <p>由于 {@code mod} 是质数，可以根据费马小定理使用
     * {@code b^(mod - 2)} 求分母 {@code b} 的模逆元。还需要满足
     * {@code r < mod}，否则分母包含 {@code mod}，模逆元不存在。</p>
     *
     * <p>时间复杂度为 {@code O(min(k, n - k) + log(mod))}，
     * 空间复杂度为 {@code O(1)}。</p>
     *
     * @param n   元素总数
     * @param k   需要选择的元素数量
     * @param mod 质数模数
     * @return {@code C(n, k) % mod}；当 {@code k < 0} 或 {@code k > n} 时返回 0
     */
    public long c(long n, int k,int mod) {
        if (k < 0 || k > n) {
            return 0;
        }

        // C(n, k) = C(n, n - k)，取较小的一侧以减少循环次数。
        long r = Math.min(k, n - k);

        // a 表示乘法公式的分子，b 表示分母 r!。
        long a = 1;
        long b = 1;

        for (long i = 1; i <= r; i++) {
            a = a * ((n - r + i) % mod) % mod;
            b = b * i % mod;
        }

        // a / b % mod 等价于 a * b^(mod - 2) % mod。
        return a * pow(b, mod - 2,mod) % mod;
    }

    /**
     * 使用二进制快速幂计算 {@code a^b % mod}。
     *
     * @param a   底数
     * @param b   非负指数
     * @param mod 模数
     * @return {@code a^b % mod}
     */
    private long pow(long a, long b,int mod) {
        long ans = 1;

        while (b > 0) {
            // 当前指数二进制最低位为 1 时，将当前底数计入答案。
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }

            // 底数平方，指数右移一位。
            a = a * a % mod;
            b >>= 1;
        }

        return ans;
    }

    /**
     * 计算两个非负整数的最大公约数。
     *
     * @param a 第一个非负整数
     * @param b 第二个非负整数
     * @return {@code a} 和 {@code b} 的最大公约数
     */
    @SuppressWarnings("unused")
    private static long gcd(long a, long b) {
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}
