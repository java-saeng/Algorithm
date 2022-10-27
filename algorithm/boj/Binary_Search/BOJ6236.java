package boj.Binary_Search;

import java.io.*;
import java.util.*;

public class BOJ6236 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N; //사용할 금액
    static int M; //돈 꺼낼 횟수
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = atoi(br.readLine());
        }

        paraSearch();
    }

    //인출할 금액
    static boolean possible(int target) {
        int cnt = 1, sum = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i];
            if(sum > target){
                cnt++;
                sum = A[i];
            }
        }
        return cnt <= M;
    }

    static void paraSearch() {
        int s = 0, e = 1000000000, rel = 0;

        for (int i = 0; i < N; i++) s = boj.Math.max(s, A[i]);

        while (s <= e) {
            int mid = (s + e) / 2;

            if (possible(mid)) {
                rel = mid;
                e = mid  - 1;
            }
            else s = mid + 1;
        }
        System.out.println(rel);
    }
}

/**
 * M번만 통장에서 돈을 뺴서 쓰기로 함
 *
 * 음수면 -> 남은 금액 통장에 집어넣고 K원 인출
 * 양수면 -> 그대로 사용
 * 0 이면 -> 양수일 댸랑 똑같이
 * 통장에서 뺀 돈으로 하루를 보낼 수 있으면 그대로 사용
 *
 * 아니면 남은 금액은 통장에 집어넣고 K원을 인출
 *
 * M번을 맞추기 위해 남은 금액이 사용할 금액보다 많으면
 * 남은 금액을 통장에 집어넣고 K원 인출할 수 있음
 *
 * M번 깨낼 때, K를 최소화한다.
 * K만큼 금액을 꺼낸다면 M을 만족하느냐?
 */
