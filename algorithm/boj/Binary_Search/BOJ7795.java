package boj.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int A[], B[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = atoi(br.readLine());

        for (int test = 0; test < test_case; test++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = atoi(st.nextToken());
            M = atoi(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = atoi(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = atoi(st.nextToken());
            }

            Arrays.sort(B);
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += binarySearch(A[i]);
            }
            System.out.println(cnt);
        }
    }

    static int binarySearch(int target) {
        int s = 0, e = M-1, mid = 0, rel = M;

        while (s <= e) {
            mid = (s + e) / 2;

            if (B[mid] < target) {
                rel = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        if(rel == M) return 0;
        return rel + 1;
    }
}