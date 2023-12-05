package ztest;


import java.util.*;

public class Programmers {
    public static void main(String[] args) {

        Solution a = new Solution();

        int[][] arr1 = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        int[] arr2 = {5, 9, 7, 10};
        int[] arr3 = {2, 36, 1, 3};
        int[] arr4 = {3, 2, 6};
        String[] arr5 = {"0123456789", "9876543210", "9999999999999"};

//        System.out.println(Arrays.toString(a.solution(arr1)));
//        System.out.println(a.solution(1));
        System.out.println(Arrays.toString(a.solution(arr2,5)));
        System.out.println(Arrays.toString(a.solution(arr3,1)));
        System.out.println(Arrays.toString(a.solution(arr4,10)));

    }
}


class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        int divCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) answer.add(arr[i]);
        }
        Collections.sort(answer);
        return answer.isEmpty() ? new int[] { -1 } : answer.stream().mapToInt(i -> i).toArray();
    }
}