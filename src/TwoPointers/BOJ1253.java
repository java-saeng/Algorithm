package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, cnt;
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = atoi(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            pro(i);
        }
        System.out.println(cnt);
    }

    static void pro(int idx) {
        int s = 0, e = N-1;
        int target = A[idx];

        while (s < e) {
            if(s == idx) s++;
            else if(e == idx) e--;

            else {
                if (target > A[s] + A[e]) s++;
                else if (target == A[s] + A[e]) {
                    cnt++;
                    return;
                } else e--;
            }
        }
    }
}
