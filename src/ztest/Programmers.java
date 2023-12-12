package ztest;

import java.util.*;

public class Programmers {
    public static void main(String[] args) {

        Solution a = new Solution();

        String[][] arr1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] arr2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"} };
        int[] arr3 = {5, 9, 7, 10};
        int[] arr4 = {2, 36, 1, 3};
        int[] arr5 = {3, 2, 6};
        String[] arr6 = {"0123456789", "9876543210", "9999999999999"};

//        System.out.println(Arrays.toString(a.solution(arr1)));
//        System.out.println(a.solution(3,arr1));
//        System.out.println(a.solution(3,arr2));
        System.out.println(Arrays.toString(a.solution(arr1)));
        System.out.println(Arrays.toString(a.solution(arr2)));
//        System.out.println(Arrays.toString(a.solution(arr4,10)));

    }
}

//[1, 1, 0],
//[1, 1, 0],
//[0, 0, 1]
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] isUsed = new boolean[tickets.length];

        for(int i=0; i<tickets.length; i++)
            System.out.print(Arrays.asList(tickets[i])+ " ");
        System.out.println("************");
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o2[1].toString().compareTo(o1[1].toString());
                else
                    return o2[0].toString().compareTo(o1[0].toString());
            }
        });

        for(int i=0; i<tickets.length; i++)
            System.out.print(Arrays.asList(tickets[i])+ " ");
        System.out.println("************");

        Stack<String[]> stack = new Stack<>();
        for (int i =0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                stack.push(tickets[i]);
                answer[0] = "ICN";
            }
        }

        for(int i = 0; i < tickets.length; i++) {
            String[] now = stack.pop();
            int nowIdx = Arrays.asList(tickets).indexOf(now);

            if (!isUsed[nowIdx]) {
                isUsed[nowIdx] = true;
                answer[i+1] = now[1];

                for (String[] next : tickets) {
                    if(next[0].equals(now[1])) {
                    if (!isUsed[Arrays.asList(tickets).indexOf(next)]) {
                        stack.push(next);
                    }}
                }
            }

        }
        return answer;
    }
}