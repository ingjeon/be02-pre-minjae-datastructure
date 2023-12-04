package recur;

public final class EuclideanGCD2 {
    public static Integer gcd(Integer large, Integer small){
        if (large % small == 0) return small;
        else return gcd(small, large % small);
        // 나머지가 당연히 작음 생각 한번 더하기
        // 8 22 시작해도 자동으로 다시 바뀜
    }
}
