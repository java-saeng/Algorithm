package Binary_Search;

import java.io.*;
import java.util.*;

public class BOJ13702 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N; //주전자 개수
    static int K; //친구 명수
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());

        A = new int[N];

        for (int i = 0; i < N; i++) A[i] = atoi(br.readLine());

        paraSearch();
    }

    static boolean possible(long target) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += A[i] / target;
        }

        return cnt >= K;
    }

    static void paraSearch() {
        long s = 0, e = Integer.MAX_VALUE, rel = 0;

        while (s <= e) {
            long mid = (s + e) / 2;

            if (possible(mid)) {
                rel = mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }

        System.out.println(rel);
    }
}

/**
 * N개의 주전자에 있는 막걸리를 K명에게 최대한 많은 양
 * -> 어떤 양이 주어질 떄, K명에게 줄 수 있느냐?
 */
