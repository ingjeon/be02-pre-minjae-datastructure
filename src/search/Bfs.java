package search;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {



    public void search(List<List<Integer>> lists, int startNum) {
        boolean[] isVisited = new boolean[lists.size()]; //false,false...

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        isVisited[startNum] = true;


        System.out.print("너비 우선 탐색 : ");
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            System.out.print(now + " ");


            for (Integer around: lists.get(now)) {
                if (!isVisited[around]){
                    queue.add(around);
                    isVisited[around] = true;
                }
            }
        }


        System.out.println();
    }
}

