package recur;

import java.util.Scanner;

public class HanoiTowerMain {
    public static void main(String[] args) {
        HanoiTower test = new HanoiTower();
        System.out.print("원반의 수를 입력 : ");
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        Integer count = test.move(num,1,3);
        System.out.println("총 "+count + "회 이동 완료");
    }
}
