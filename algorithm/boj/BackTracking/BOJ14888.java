package boj.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static int op[] = new int[5];
    static int A[];
    static int orders[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        StringTokenizer st;

        A = new int[N + 1];
        orders = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < 5; i++) {
            op[i] = atoi(st.nextToken());
        }

        pro(1, A[1]);

        sb.append(max + "\n" + min);

        System.out.print(sb);
    }

    private static void pro(int cnt, int value) {
        if (cnt == N) {
            max = boj.Math.max(value, max);
            min = boj.Math.min(value, min);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if(op[i] > 0){
                op[i]--;
                int newValue = value;
                if(i == 1){
                    newValue += A[cnt + 1];
                }
                if(i == 2){
                    newValue -= A[cnt + 1];
                }
                if(i == 3){
                    newValue *= A[cnt + 1];
                }
                if(i == 4){
                    newValue /= A[cnt + 1];
                }
                pro(cnt + 1, newValue);
                op[i]++;
            }
        }
    }
}
