package boj.bfs_dfs;

import java.util.*;
import java.io.*;

public class BOJ11725{
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static int rel[];
    static ArrayList<Integer>[] al;
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = atoi(br.readLine());

        rel = new int[N + 1];
        al = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            al[s1].add(s2);
            al[s2].add(s1);
        }

        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(rel[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int element = q.poll();

            for (int value : al[element]) {
                if(visit[value]) continue;
                q.offer(value);
                visit[value] = true;
                rel[value] = element;
            }
        }
    }
}