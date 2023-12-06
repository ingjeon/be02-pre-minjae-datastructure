package recur;

public class Factorial {
    public Integer opr1(Integer num) {
        Integer result = num;
        for (int i = num - 1; i > 0; i--) {
            result = result * i;
        }
        return result;
    }
    // opr2 재귀
    public Integer opr2(Integer num) {
        if(num > 0) {
            return num * opr2(num - 1);
        } else {
            return 1;
        }
    }
}
