package Binary_Search;

import java.io.*;
import java.util.*;

public class BOJ2343 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int N; //강의 수
    static int M; //블루레이 개수
    static int a[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        a = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[i] = atoi(st.nextToken());
        }

//        Arrays.sort(a);
        paraSearch();

    }

    //target은 블루레이 크기
    static boolean possible(int target) {
        int cnt = 1, sum = 0;

        for (int i = 0; i < N; i++) {
            sum += a[i];
            if(sum > target){
                cnt++;
                sum = a[i];
            }
        }
        return cnt <= M;
        //cnt가 M보다 작거나 같다 -> 블루레이 크기가 크다\
        //-> 그것들 중에 제일 왼쪽 값
    }

    static void paraSearch() {
        int s = 0, e = 1000000000, rel = 0;

        for (int i = 0; i < N; i++) s = Math.max(s, a[i]);
        while (s <= e) {
            int mid = (s + e) / 2;

            if (possible(mid)) {
                rel = mid;
                e = mid - 1;
            }
            else s = mid + 1;
        }
        System.out.println(rel);
    }
}
/**
 * M개의 블루레이에 담을 때, 블루레이의 최소 크기?
 * -> 블루레의의 크기가 S 일 때, M개의 블루레이를 만족하냐?
 */
