package template.math;

/**
 * 最大公约数
 *
 * @author chen
 * @date 2022-02-10
 **/
public class Gcd {

    /**
     * 穷举法
     */
    @Deprecated
    public static int gcd_exhaustively(int a, int b) {
        for (int i = 2; i < Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 辗转相除法
     */
    public static int gcd_division_recursive(int a, int b) {
        return b == 0 ? a : gcd_division_recursive(b, a % b);
    }
