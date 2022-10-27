package boj.BruteForce_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int A[];
    static int N;
    static int select[];
    static boolean visit[];
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        pro(0);

        System.out.println(ans);
    }

    static void pro(int cnt) {
        if (cnt == N) {
            ans = boj.Math.max(ans, getSum(select));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            select[cnt] = A[i];
            pro(cnt + 1);
            visit[i] = false;
        }

    }

    static int getSum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += boj.Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new int[N];
        select = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = atoi(st.nextToken());
        }
    }
}