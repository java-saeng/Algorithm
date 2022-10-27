package boj.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int n, x;
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = atoi(br.readLine());

        A = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            A[i] = atoi(st.nextToken());
        }

        x = atoi(br.readLine());

        Arrays.sort(A);

        pro();
    }

    static void pro() {
        int s = 1, e = n, cnt = 0;

        while (s < e) {
            int sum = A[s] + A[e];

            if(sum == x){
                cnt++;
                s++;
                e--;
            }
            else if(sum > x) e--;
            else s++;
        }
        System.out.println(cnt);
    }
}
