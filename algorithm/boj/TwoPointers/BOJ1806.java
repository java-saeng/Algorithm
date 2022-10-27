package boj.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, S;
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        S = atoi(st.nextToken());

        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }

        pro();
    }

    static void pro() {
        int e = 0, rel = N + 1, sum = 0;

        for (int s = 1; s <= N; s++) {
            sum -= A[s - 1];

            while (e + 1 <= N && sum < S) {
                sum += A[++e];
            }

            if (sum >= S) {
                rel = boj.Math.min(rel, e - s + 1);
            }
        }

        if(rel == N+1) rel = 0;

        System.out.println(rel);
    }
}
