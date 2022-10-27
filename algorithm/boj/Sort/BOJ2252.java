package boj.Sort;

import java.io.*;
import java.util.*;

public class BOJ2252 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static ArrayList<Integer> A[];
    static int deg[];
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < deg.length; i++) {
            if(deg[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int m = q.poll();
            sb.append(m + " ");
            for(int n : A[m]){
                deg[n]--;
                if(deg[n] == 0) q.offer(n);
            }
        }

        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        deg = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());

            A[s1].add(s2);
            deg[s2]++;
        }
    }
}
