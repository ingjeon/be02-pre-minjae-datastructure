package path.teacher.astar;

import java.util.*;

public class Astar {
    final Integer DEFAULT_COST = 10;
    final Integer DEFAULT_DIAGONAL_COST = 14;


    // 맵의 크기 저장 변수
    Integer rowSize;
    Integer colSize;


    // 초기화할 때 맵 정보를 전달 받아서 출발지와 목적지의 좌표를 변수에 저장
    Integer[][] map;

    Node start;

    Node goal;

    // 열린 목록 저장할 변수
    ArrayList<Node> openList;

    // 닫힌 목록 저장할 변수
    ArrayList<Node> closeList;


    public Astar(Integer[][] map) {
        this.map = map;

        // 맵 크기 초기화
        rowSize = map.length;
        colSize = map[0].length;

        // 열린 목록 초기화
        openList = new ArrayList();
        // 닫힌 목록 초기화
        closeList = new ArrayList();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 1) {
                    this.start = new Node(j, i);
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 2) {
                    this.goal = new Node(j, i);
                }
            }
        }
    }

    public void findPath() {
        // 시작점를 '열린 목록'에 넣는다.
        openList.add(this.start);

        // 열린 목록이 비어 있지 않으면 반복, 리스트가 비어있는지 아닌지 확인은 리스트변수.isEmpty()
        while (openList.isEmpty() != true) {
//            열린 목록에서 제일 처음 노드를 가져온다(가져온 노드는 목록에서 삭제)
            Node node = openList.get(0);
            openList.remove(0);

//            가져온 노드는 닫힌 목록에 넣어준다.
            closeList.add(node);

//            만약 가져온 노드가 최종 목적지면
            if (goal.x == node.x && goal.y == node.y) {
//                  최종 경로 출력
                List<Node> path = new ArrayList<>();
                while (node.parents != null) {
                    path.add(0, node);
                    node = node.parents;
                }

                for (int i = 0; i < path.size(); i++) {
                    System.out.print("["+path.get(i).x+","+path.get(i).y+"]");
                }

            }
//            그렇지 않으면
            else {
                // addAdjacentNodes 메소드 실행
                this.addAdjacentNodes(node);
            }
        }
    }

    public Boolean isDuplicate(Node adjacentNode) {
        // 열린 목록에 있는 노드를 하나씩 가져오면서 반복
        for (int i = 0; i < openList.size(); i++) {
            // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
            if(!openList.isEmpty() &&
                    openList.get(i).x == adjacentNode.x && openList.get(i).y == adjacentNode.y) {
                //      중복
                return true;
            }
        }

        // 닫힌 목록에 있는 노드를 하나씩 가져오면서 반복
        for (int i = 0; i < closeList.size(); i++) {
            // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
            if(!closeList.isEmpty() &&
                    closeList.get(i).x == adjacentNode.x && closeList.get(i).y == adjacentNode.y) {
                //      중복
                return true;
            }
        }

        // 중복 아님
        return false;
    }

    public void addAdjacentNodes(Node currentNode) {
        // 전달 받은 노드의 X,Y 좌표를 따로 저장
        Integer x;
        x = currentNode.x;

        Integer y;
        y = currentNode.y;

        // 왼위, 오위, 왼아, 오아, 위, 아, 왼, 오
        Integer[] xArr = {x - 1, x + 1, x - 1, x + 1, x, x, x - 1, x + 1};
        Integer[] yArr = {y - 1, y - 1, y + 1, y + 1, y - 1, y + 1, y, y};

        for (int i = 0; i < xArr.length; i++) {
            // 인접한 좌표가 맵 크기를 넘지 않고 맵에서 장애물이 아니면
            if (xArr[i] > -1 && xArr[i] < colSize
                    && yArr[i] > -1 && yArr[i] < rowSize
                    && map[yArr[i]][xArr[i]] != 3) {

                // FGH 계산해서 각각 변수에 저장
                Integer h;
                h = (int) Math.sqrt( Math.pow(goal.x - xArr[i],2) + Math.pow(goal.y - yArr[i],2));

                Integer g;
                if (i < 4) {
                    g = DEFAULT_DIAGONAL_COST + currentNode.g;
                } else {
                    g = DEFAULT_COST + currentNode.g;
                }

                Integer f;
                f = g + h;

                // 새로운 노드 생성(전달해줄거 전달해서 생성)
                Node adjacentNode = new Node(xArr[i], yArr[i], f, g, h, currentNode);

                // isDuplicate 메소드 실행해서 결과를 저장
                Boolean isDuplicate = isDuplicate(adjacentNode);

                // 만약에 isDuplicate 메소드 실행 결과가 거짓이면
                if(!isDuplicate) {
                    //      생성한 노드를 열린 목록에 넣는다
                    openList.add(adjacentNode);

                    //      F 값을 기준으로 정렬 오름차순 정렬
                    for (int j = 0; j < openList.size(); j++) {
                        for (int k = 1; k < openList.size(); k++) {
                            if(openList.get(j).f > openList.get(k).f) {
                                Collections.swap(openList, j, k);
                            }
                        }
                    }
                }
            }
        }
    }
}
