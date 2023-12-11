package path;

public class Test {
    public static void main(String[] args) {
        Integer[][] map = {
                {0,0,1,0,0,0,3,0,0,0},
                {0,0,0,0,0,0,3,0,0,0},
                {0,0,0,0,0,0,3,0,0,0},
                {0,0,0,0,0,0,3,0,2,0},
                {0,0,0,0,0,0,3,0,0,0},
                {0,0,3,0,3,0,3,0,0,0},
                {0,0,3,0,3,0,3,0,0,0},
                {0,0,3,3,3,3,3,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };

        Astar astar = new Astar(map);

        System.out.println("***********");

        astar.findPath();
    }
}
