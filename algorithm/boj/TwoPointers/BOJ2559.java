package boj.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
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
        int s = 1, e = K, sum = 0, rel = Integer.MIN_VALUE;

        for (int i = 1; i <= K; i++) {
            sum += A[i];
        }

        rel = boj.Math.max(rel, sum);

        while (e + 1 <= N) {
            sum = sum - A[s++] + A[++e];

            rel = boj.Math.max(rel, sum);
        }

        System.out.println(rel);
    }
}
