package ztest;

public class PraRecur {



    //1~n 곱
    public int recursive1(int i) {
        if (i == 1) return 1;
        return i * recursive1(i-1);
    }

    // 피보나치 ~n 1 1 2 3 5
    public int recursive2(int n) {
        if (n == 1 || n ==2) return 1;
        return  recursive2(n-2)+ recursive2(n-1);
    }

    // 최대공약수 유클리드
    public int recursive3(int n, int m) {
        if (m == 0) return n;
        return recursive3(m,n%m);
    }










    public static void main(String[] args) {
        PraRecur test = new PraRecur();
        int answer1 = test.recursive1(5);
        int answer2 = test.recursive3(10,30);
        System.out.println(answer2);
    }
}
