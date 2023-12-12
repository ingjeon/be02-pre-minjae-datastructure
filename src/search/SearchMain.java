package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMain {
    public static void main(String[] args) {
        // 숫자들을 저장한 리스트
        List<Integer> list = new ArrayList<>();
        // 숫자들을 저장한 리스트들을 저장한 리스트
        List<List<Integer>> lists = new ArrayList<>();

        // 0번 노드에 1,3,4 연결 되있음
        List<Integer> list0 = Arrays.asList(1,3,4);
        List<Integer> list1 = Arrays.asList(0,2);
        List<Integer> list2 = Arrays.asList(1,3);
        List<Integer> list3 = Arrays.asList(0,2,4);
        List<Integer> list4 = Arrays.asList(0,3);
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        Dfs dfs = new Dfs();
        dfs.search(lists, 0);
//        dfs.searchRecursive(lists, 0);
        System.out.println(list0);
        Bfs bfs = new Bfs();
        bfs.search(lists, 0);

    }
}
