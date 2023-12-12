package search;

import java.util.*;

public class Programmers43164 {
    public static void main(String[] args) {

        Solution a = new Solution();

        String[][] arr1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] arr2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};


        System.out.println(Arrays.toString(a.solution(arr1)));
        System.out.println(Arrays.toString(a.solution(arr2)));

    }
}

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[] isUsed = new boolean[tickets.length];
        answer[0] = "ICN";

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        for(int i=0; i<tickets.length; i++)
            System.out.print(Arrays.asList(tickets[i])+ " ");
        System.out.println("************");


        for (int j= 0; j < tickets.length; j++) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i][0].equals(answer[j])) {
                    answer[j+1] = tickets[i][1];
                    isUsed[i]=true;
                    break;
                }
            }
        }

//        for (int i = 0; i < tickets.length; i++) {
//            String[] now = list.pop();
//            int nowIdx = Arrays.asList(tickets).indexOf(now);
//
//            if (!isUsed[nowIdx]) {
//                isUsed[nowIdx] = true;
//                answer[i + 1] = now[1];
//
//                for (String[] next : tickets) {
//                    if (next[0].equals(now[1])) {
//                        if (!isUsed[Arrays.asList(tickets).indexOf(next)]) {
//                            list.push(next);
//                        }
//                    }
//                }
//            }
//
//        }
        return answer;
    }
}


