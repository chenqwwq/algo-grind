package template.math;

public class Lcm {

    /**
     * 求最小公倍数
     */
    public static int lcm(int a, int b) {
        return a / Gcd.gcd_division_recursive(a, b) * b;
    }
}
