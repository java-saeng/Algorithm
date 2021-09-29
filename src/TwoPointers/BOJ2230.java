package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = atoi(br.readLine());
        }

        Arrays.sort(A);
        pro();
    }

    static void pro() {
        int e = 0, min = Integer.MAX_VALUE;

        for (int s = 1; s <= N; s++) {
            while(e+1 <= N && A[e] - A[s] < M){ //여기도 <=라함
                ++e;
            }
            if(A[e] - A[s] >= M){ //이 부분을 간과함
                min = Math.min(min, A[e] - A[s]);
            }
        }
        System.out.println(min);
    }
}
