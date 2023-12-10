package sort.merge;

import java.util.Arrays;

public class TopDownMerge {

    public static int[] sorted;        // 정렬하면서 합칠 때 저장 보조 배열

    public static void merge_sort(int[] arr) { // 정적 메소드 merge_sort
        // [8,2,6,4,7,3,9,5]
        sorted = new int[arr.length]; // 원본 길이만큼 배열
        merge_sort(arr, 0, arr.length - 1); // 매개 변수 배열,이상,이하
    }

    private static void merge_sort(int[] arr, int left, int right) {
        // 부분리스트 원소 1개 면 쪼갤수 없음
        if (left == right) return; // void에서만 return;
        // break는 해당 반복문 종료, return은 해당 메소드가 호출된 곳 종료
        int mid = (left + right) / 2;    // 절반으로 나눌 위치

        merge_sort(arr, left, mid);        // 왼쪽 부분리스트(left ~ mid)
        merge_sort(arr, mid + 1, right);    // 오른쪽 부분리스트(mid+1 ~ right)

        merge(arr, left, mid, right);        // 병합 메소드
        System.out.println("보조 배열 : " + Arrays.toString(sorted)); // 보조 배열 상태
        System.out.println("원본 : " + Arrays.toString(arr)); // 배열 상태
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;        // 왼쪽 부분리스트 시작점
        int r = mid + 1;    // 오른쪽 부분리스트의 시작점
        int idx = left;        // 채워넣을 보조 배열의 인덱스

        // 왼쪽 : left 이상 mid 이하, 오른쪽 : mid+1이상 right이하
        while (l <= mid && r <= right) {
            // 보조배열에 들어가지 않은
            // 왼쪽 l번째 원소 <= 오른쪽 r번째 원소 면
            // 보조 배열에 작은 l번째 원소 넣고 l++
            if (arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                idx++; // 보조 배열 index++
                l++;
            }
            // 오른쪽 r번째 원소가 작으 면
            // 보조 배열에 작은 r번째 원소 넣고 r++
            else {
                sorted[idx] = arr[r];
                idx++; // 보조 배열 index++
                r++;
            }
        }
        // 왼쪽 리스트 모두 등록, left 이상 mid 이하
        // 오른쪽(정렬하면서 합침)으로 채움
        if (l > mid) {
            while (r <= right) {
                sorted[idx] = arr[r];
                idx++; // 보조 배열 index++
                r++;
            }
        }
        // 오른쪽 리스트 모두 등록, mid+1이상 right이하
        // 왼쪽(정렬하면서 합침)으로 채움
        else {
            while (l <= mid) {
                sorted[idx] = arr[l];
                idx++; // 보조 배열 index++
                l++;
            }
        }
        //합치면서 정렬된 부분을 기존의 배열에 복사
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}