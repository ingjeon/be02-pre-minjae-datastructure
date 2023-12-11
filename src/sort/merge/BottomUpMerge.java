package sort.merge;

import java.util.Arrays;

public class BottomUpMerge {
    private static int[] sorted;		// 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static int c = 0;
    public static void mergeSort(int[] arr) {
        // [8,2,6,4,7,3,9,5]
        sorted = new int[arr.length]; // 원본 길이만큼 배열
        System.out.println("***********************************");
        System.out.println("### "+c+"회전 ###");
        System.out.println("보조 배열 : " + Arrays.toString(sorted)); // 보조 배열 상태
        System.out.println("원본 배열 : " + Arrays.toString(arr));
        System.out.println("***********************************");
        mergeSort(arr, 0, arr.length - 1); // 매개 변수 배열,이상,이하
    }
    // Bottom-Up 방식 구현
    private static void mergeSort(int[] arr, int left, int right) {
        // 1, 2, 4, 8... 식으로 1부터 부분리스트 나누는 원소개수 기준 두 배씩 늘림
        for(int size = 1; size <= right; size += size) {

            // 두 부분리스트 순서대로 왼쪽부터 병합
            //low 이상 mid 이하 / mid+1 이상 high 이하
            for(int l = 0; l <= right - size; l += (2 * size)) {
                int low = l;
                int mid = l + size - 1;
                int high = l + (2 * size) - 1;
                // 배열이 2^n승이 아닐 경우 마지막 병합에서 l+2*size-1 > right
                if (high > right) high = right;
                merge(arr, low, mid, high);		// 병합 메소드

                System.out.println("원본 배열 : " + Arrays.toString(arr)); // 배열 상태
                System.out.println("***********************************");
            }
        }
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
        c++;
        System.out.println("### "+c+"회전 ###");
        System.out.println("보조 배열 : " + Arrays.toString(sorted)); // 보조 배열 상태
        System.out.println("index : "+left+" ~ "+right+" 부분 병합 업데이트");
    }
}
