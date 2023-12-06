package recur;

/**
 * 움직익 한문장씩 출력
 * hanoi(N) N 개 원반을 다른곳으로
 * hanoi(N-1) N-1 개 원반을 다른곳으로
 *  => 재귀
 *
 * 가장 큰 원반 제외 치우기
 * 	첫 번째 재귀 : N-1 개의 원반을 "A"에서 "B"로 옮긴다.
 * 가장 큰 원반 "A" 에서 "C"
 * 가장 큰 원반 제외 올리기
 * 	두 번쨰 재귀 : N-1 개의 원반을 "B"에서 "C"로 옮긴다.
 *  => 재귀 2번
 *
 * 핵심 매개변수 원반번호, 출발, 도착,(경유 123  6-출발,도착)
 *
 *
 * hanoi(3, "A", "C", "B")
 * 	hanoi(2, "A", "B", "C"): "A"에서 "C"를 거쳐 "B"에 1번
 * 	 2번 원반을 옮긴다.
 * 	"A"에 있는 3번원반을 "C"지점으로 옮긴다.
 * 	hanoi(2, "B", "C", "A"): "B"에 있는 두개의 원반을 "A"를
 * 	 거쳐 "C"로 옮긴다.
 */
public class HanoiTower {
    Integer count;

    public HanoiTower() {
        this.count = 0;
    }

    public Integer move(Integer num, Integer start, Integer end) {
        if(num == 1) {
            System.out.println("원반["+num+"] : "+start+"번 기둥 => "+end+"번 기둥");
            count = count + 1;
        }
        else {
            move(num - 1,start,6-start-end);
            System.out.println("원반["+num+"] : "+start+"번 기둥 => "+end+"번 기둥");
            count = count + 1;
            move(num - 1,6-start-end,end);
        }
        return count;
    }
}
