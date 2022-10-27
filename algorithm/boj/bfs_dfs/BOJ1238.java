package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M, X;
    static ArrayList<Node> A[];
    static ArrayList<Node> B[];
    static int dist1[];
    static int dist2[];
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        dijkstra(X, dist1, A);
        dijkstra(X, dist2, B);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = boj.Math.max(max, dist1[i] + dist2[i]);
        }
        System.out.println(max);
    }

    static void dijkstra(int start, int d[], ArrayList<Node> al[]) {
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->{
            return o1.dist - o2.dist;
        });

        pq.offer(new Info(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            for (Node n : al[info.idx]) {

                if(d[info.idx] != info.dist) continue;

                if(d[info.idx] + n.wei >= d[n.to]) continue;

                d[n.to] = d[info.idx] + n.wei;
                pq.offer(new Info(n.to, d[n.to]));
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        X = atoi(st.nextToken());

        A = new ArrayList[N + 1];
        B = new ArrayList[N + 1];
        dist1 = new int[N + 1];
        dist2 = new int[N + 1];

        for (int i = 0; i <= N; i++){
            A[i] = new ArrayList<>();
            B[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            A[from].add(new Node(to, wei));
            B[to].add(new Node(from, wei));
        }
    }

    static class Node{
        int to, wei;

        public Node(int to, int wei) {
            this.to = to;
            this.wei = wei;
        }
    }

    static class Info{
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}