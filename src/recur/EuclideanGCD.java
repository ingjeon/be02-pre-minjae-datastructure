package recur;

public class EuclideanGCD {
    public void gcd(int x, int y) {
        int tmp;
        if (x < y) {
            tmp = x;
            x = y;
            y = tmp;
        } else if (x == y) System.out.println(y);

        if (x % y == 0) System.out.println(y);
        else gcd(x % y, y);
    }
}
