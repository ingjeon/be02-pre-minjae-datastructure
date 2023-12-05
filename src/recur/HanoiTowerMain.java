package recur;

public class HanoiTowerMain {
    public static void main(String[] args) {
        HanoiTower test = new HanoiTower();
        int count = test.move(3,1,3);
        System.out.println(count);

    }
}
