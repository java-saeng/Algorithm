package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13144 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int N;
    static int A[];
    static int possible[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }

        pro();
    }

    static void pro() {
        int e = 0;
        long cnt = 0;

        for (int s = 1; s <= N; s++) {
            if(possible[A[s-1]] > 0) possible[A[s-1]]--;

            while (e + 1 <= N && possible[A[e + 1]] <= 0) {
                possible[A[++e]]++;
            }

            cnt += (e - s + 1);
        }

        System.out.println(cnt);
    }
}
