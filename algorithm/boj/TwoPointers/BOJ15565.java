package boj.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15565 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, K;
    static int A[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());

        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }

        pro();
    }

    static void pro() {
        int e = 0, rel = N+1, cnt = 0;

        for (int s = 1; s <= N; s++) {
            if(A[s-1] == 1){
                cnt--;
            }

            while (e + 1 <= N && cnt < K) {
                if(A[++e] == 1) cnt++;
            }

            if(cnt == K) rel = boj.Math.min(rel, e - s + 1);
        }

        if(rel == N + 1) rel = -1;

        System.out.println(rel);
    }
}
