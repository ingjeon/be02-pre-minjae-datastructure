package ztest;

import java.util.*;

public class Programmers {
    public static void main(String[] args) {

        Solution a = new Solution();

        String[][] arr1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] arr2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"} };
        int[] arr3 = {70, 50, 80, 50};
        int[] arr4 = {70, 80, 50};
        int[] arr5 = {3, 2, 6};
        String[] arr6 = {"0123456789", "9876543210", "9999999999999"};

//        System.out.println(Arrays.toString(a.solution(arr1)));
        System.out.println(a.solution(arr3,100));
        System.out.println(a.solution(arr4,100));
//        System.out.println(Arrays.toString(a.solution(arr1)));
//        System.out.println(Arrays.toString(a.solution(arr2)));
//        System.out.println(Arrays.toString(a.solution(arr4,10)));

    }
}
// 구명 보트 최대 2명 무게제한limit
//

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;


        return answer;
    }
}
