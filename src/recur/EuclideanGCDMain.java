package recur;

public class EuclideanGCDMain {
    public static void main(String[] args) {
        EuclideanGCD test = new EuclideanGCD();
        test.gcd(22,8);

        int answer = EuclideanGCD2.gcd(22,8);
        System.out.println(answer);
    }
}
