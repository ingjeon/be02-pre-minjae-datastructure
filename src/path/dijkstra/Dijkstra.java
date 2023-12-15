package path.dijkstra;

import java.util.Arrays;
import java.util.Comparator;

public class Dijkstra {
//    {{0,2,8},{0,3,4},{0,4,8},{1,2,1},
//        {1,5,9},{2,5,5},{3,5,8},{3,7,7},
//        {4,6,2},{4,7,8},{6,7,2}};


    Integer[][] graph;
    boolean[] visited ;
    int[] cost;
    int[] path;


    // 가장 작은 노드 부터 시작
    public void findPath(int nodesNum, Integer[][] graph) {
        visited  = new boolean[nodesNum];
        cost = new int[nodesNum];
        for (int i = 1; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE; //0제외값을 INF로 초기화
        }
        System.out.println(Arrays.toString(cost));
        path = new int[nodesNum];

        // 가장 작은 노드 찾기
        int startNode = graph[0][0];
        path[startNode] = -1;
//        findPath(startNode, nodesNum, graph);
    }

    public void findPath(int nowNode, int nodesNum, Integer[][] graph) {

            // 다음 최소값 찾아서 아직 false면  재실행
            int min = 999999999;
            int minIdx = 0;
            for (int i =0; i< cost.length; i++){
                if(!visited [i]&&cost[i]!=0&&min > cost[i]) {
                    min =cost[i];
                    minIdx = i;
                }
            }
            findPath(minIdx,nodesNum,graph);


    }

    public boolean isEnd() {
        for (boolean isfalse : visited) {
            if (!isfalse) return false;
        }
        return true;
    }
}
