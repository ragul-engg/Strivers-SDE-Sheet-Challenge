package arrays_iii;

public class PowXY {
    public static double myPow(double x, int n) {
        double ans = 1.0;
        long power = n;
        if (power < 0) {
            power *= -1;
        }
        while (power > 0) {
            if (power % 2 == 0) {
                x *= x;
                power /= 2;
            } else {
                ans *= x;
                power--;
            }
        }
        if (n < 0) {
            return 1.0 / ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
    }
}