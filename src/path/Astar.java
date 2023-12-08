package path;

import java.util.ArrayList;
import java.util.List;

public class Astar {
    // 초기화할 때 맵 정보를 전달 받아서 출발지 목적지 좌표변수에 저장

    static final int DISTANCE_COST = 10;
    static final int DISTANCE_DIAGONAL_COST = 14;

    Integer[][] map;
    Node start;
    Node goal;
    List<Node> openList;
    List<Node> closeList;

    int[][] move = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0}, {-1, 0},
            {-1, 1}, {0, 1}, {1, 1}
    };

    public Astar(Integer[][] map) {
        // 맵, 열린 목록,닫힌 목록 초기화
        this.map = map;
        openList = new ArrayList<>();
        closeList = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    start = new Node(j, i);
                }
                if (map[i][j] == 2) {
                    goal = new Node(j, i);
                }
            }
        }
        System.out.println("시작 : " + start.x + "," + start.y);
        System.out.println("도착 : " + goal.x + "," + goal.y);
    }

    //메소드 이름 동사가 들어가면 좋다
    public void findPath() {
        // 시작점를 '열린 목록'에 넣는다.
        openList.add(0, start);
        // 열린 목록이 비어 있지 않으면 반복, 리스트가 비어있는지 아닌지 확인은 리스트변수.isEmpty()
        while (!openList.isEmpty()) {
//            열린 목록에서 제일 처음 노드를 가져온다(가져온 노드는 목록에서 삭제)
            Node smallF = openList.get(0);
            openList.remove(0);
//            가져온 노드는 닫힌 목록에 넣어준다
            if (isDuplicate(smallF)) closeList.add(smallF);
//            만약 가져온 노드가 최종 목적지면
            if (goal.x.equals(smallF.x) && goal.y.equals(smallF.y)) {
                printFinalPath(smallF);
//                break;
            } else {
                // addAdjacentNodes 메소드 실행
                addAdjacentNodes(smallF);
            }
        }
    }

    public Boolean isDuplicate(Node adjacentNode) {
        // 열린 목록에 있는 노드를 하나씩 가져오면서 반복
        // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
        //      중복
        for (int i = 0; i < openList.size(); i++) {
            if (openList.get(i).x.equals(adjacentNode.x) && openList.get(i).y.equals(adjacentNode.y)) {
                return false;
            }
        }
        // 닫힌 목록에 있는 노드를 하나씩 가져오면서 반복
        // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
        //      중복
        for (int i = 0; i < closeList.size(); i++) {
            if (closeList.get(i).x.equals(adjacentNode.x) && closeList.get(i).y.equals(adjacentNode.y)) {
                return false;
            }
        }
        // 중복 아님
        return true;
    }

    public void addAdjacentNodes(Node currentNode) {
        // 전달 받은 노드의 X,Y 좌표를 따로 저장
        int curX = currentNode.x;
        int curY = currentNode.y;
        // 왼위, 위, 오위, 왼, 오, 왼아, 아, 오아
        // 인접한 좌표가 맵 크기를 넘지 않고 맵에서 장애물이 아니면
        for (int i = 0; i < move.length; i++) {
            int x = curX + move[i][0];
            int y = curY + move[i][1];
            if (0 <= y && y < map.length && 0 <= x &&
                    x < map[0].length && map[x][y] != 3) {
                // FGH 계산해서 각각 변수에 저장
                int G;
                if (x == curX || y == curY) {
                    G = currentNode.g + DISTANCE_COST;
                } else G = currentNode.g + DISTANCE_DIAGONAL_COST;
                int H = (Math.abs(goal.x - curX) + Math.abs(goal.y - curY)) * 10;
                int F = H + G;
                // 새로운 노드 생성(전달해줄거 전달해서 생성)
                Node adjacentNode = new Node(x, y);
                adjacentNode.g = G;
                adjacentNode.h = H;
                adjacentNode.f = F;
                adjacentNode.parents = currentNode;
                // isDuplicate 메소드 실행해서 결과를 저장
                boolean isOk = isDuplicate(adjacentNode);
                // 만약에 isDuplicate 메소드 실행 결과가 거짓이면
                if (isOk) {
                    //      생성한 노드를 열린 목록에 넣는다
                    //      F 값을 기준으로 정렬 오름차순 정렬
                    // => 노드 add 할때 정렬 된 위치에
                    int check = 0;
                    for (int k = 0; k < openList.size(); k++) {
                        if (openList.isEmpty()) openList.add(adjacentNode);
                        if (adjacentNode.f < openList.get(k).f) {
                            check = k;
                        }
                    }
                    if (check == 0) openList.add(adjacentNode);
                    else openList.add(check, adjacentNode);
                    // 거품정렬 버전
//                    //      생성한 노드를 열린 목록에 넣는다
//                    openList.add(adjacentNode);
//                    //      F 값을 기준으로 정렬 오름차순 정렬
//                    for (int k = 0; k < openList.size() - 1; k++) {
//                        for (int j = 0; j < openList.size() - k - 1; j++) {
//                            if (openList.get(j).f > openList.get(j + 1).f) {
//                                Node tmp = openList.get(j);
//                                openList.remove(j);
//                                openList.add(j + 1, tmp);
//                            }
//                        }
//                    }
                }
            }
        }
    }

    public void printFinalPath(Node last) {
        // 특정 노드를 하나 전달 받아서
        // 닫힌 목록에서 부모 부모 부모 찾아가서 출발지 나오면
        // 출발지 부터 출력
        if (last.parents != null) {
            printFinalPath(last.parents);
            System.out.println(last.x + ", " + last.y);
        } else System.out.println(last.x + ", " + last.y);
    }
}
