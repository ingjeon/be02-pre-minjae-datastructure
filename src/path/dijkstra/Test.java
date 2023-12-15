package path.dijkstra;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[][] graph =
                {{0,2,8},{0,3,4},{0,4,8},{1,2,1},
                        {1,5,9},{2,5,5},{3,5,8},{3,7,7},
                        {4,6,2},{4,7,8},{6,7,2}};
//                {{0,1,4},{0,2,3},{2,1,3}};

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.findPath(8,graph);
        System.out.println("********************");
        System.out.println(Arrays.toString(dijkstra.visited));
        System.out.println("cost "+Arrays.toString(dijkstra.cost));
        System.out.println("path "+Arrays.toString(dijkstra.path));
    }
}
