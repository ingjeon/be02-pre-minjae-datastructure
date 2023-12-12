package greedy;

import java.util.*;

public class Programmers42862 {
    class Solution {
        // 옆번호만 빌려줄수있음
        // 도난 여분 동시 가능
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n - lost.length;
            Arrays.sort(lost);
            Arrays.sort(reserve);
            for (int i = 0; i < reserve.length; i++) {
                for (int j = 0; j < lost.length; j++) {
                    if (reserve[i] == lost[j]) {
                        lost[j] = 33;
                        reserve[i] = 33;
                        answer = answer + 1;
                    }
                }
            }
            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] - reserve[j] == 1) {
                        reserve[j] = 33;
                        lost[i] = 33;
                        answer = answer + 1;
                    }
                    if (lost[i] - reserve[j] == -1) {
                        reserve[j] = 33;
                        lost[i] = 33;
                        answer = answer + 1;
                    }
                }
            }
            return answer;
        }
    }
}
