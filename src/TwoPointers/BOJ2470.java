package TwoPointers;

import java.io.*;
import java.util.*;

public class BOJ2470 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
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

        pro();
    }

    static void pro() {
        int s = 0, e = N - 1, s1 = 0, s2 = 0;
        int ans = Integer.MAX_VALUE;
        //s < e인 이유는 똑같은 용액 합치기 X
        while (s < e) {
            int sum = A[s] + A[e];

            if(ans > Math.abs(sum)){
                s1 = s;
                s2 = e;
                ans = Math.abs(sum);
            }

            if(sum > 0) e--;
            else s++;
        }

        System.out.println(A[s1] + " " + A[s2]);
    }
}
