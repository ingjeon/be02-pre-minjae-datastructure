package search;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Dfs {
    public void search(List<List<Integer>> lists, int startNum) {
        boolean[] isVisited = new boolean[lists.size()]; //false,false...
        // Boolean으로 만들면 false로 초기화 필수

        Stack<Integer> stack = new Stack<>();
        stack.push(startNum);

        System.out.print("깊이 우선 탐색 : ");
        while (!stack.isEmpty()) {
            Integer now = stack.pop();

            if (!isVisited[now]) {
                System.out.print(now + " ");
                isVisited[now] = true;


                Collections.reverse(lists.get(now));
                for (int around : lists.get(now)) {
                    if (!isVisited[around]) {
                        stack.push(around);
                    }
                }
            }
        }
        System.out.println();
    }

    public void searchRecursive(List<List<Integer>> lists, Integer startNum) {
        System.out.print("깊이 우선 탐색 : ");
        searchRecursive(lists, startNum, new boolean[lists.size()]);
        System.out.println("재귀 방식");
    }
    public void searchRecursive(List<List<Integer>> lists, Integer now, boolean[] isVisited) {
    }



}





























//        if (!visited[node]) {
//                System.out.print(node + " ");
//                visited[node] = true;
//
//                List<Integer> neighbors = lists.get(node);
//        Collections.reverse(neighbors);
//        for (int neighbor : neighbors) {
//        searchRecursive(lists, neighbor, visited);
//        }
//        }