package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1719 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int parent[];
    static ArrayList<Info> A[];
    static int N, M;
    static int dist[];
    static int ans[][];
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) {
                    System.out.print("-" + " ");
                    continue;
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->{
            return o1.dist - o2.dist;
        });

        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++) parent[i] = i;

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Info in : A[node.idx]) {

                if(dist[node.idx] != node.dist) continue;

                if(dist[node.idx] + in.wei >= dist[in.to]) continue;

                dist[in.to] = dist[node.idx] + in.wei;
                pq.offer(new Node(in.to, dist[in.to]));
                parent[in.to] = node.idx;
            }
        }

        for (int i = 1; i <= N; i++) {
            ans[start][i] = find(i, start);
        }
    }

    static int find(int v, int start) {
        if(parent[v] == start) return v;

        return find(parent[v], start);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        ans = new int[N+1][N+1];
        dist = new int[N+1];
        parent = new int[N+1];

        A = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) A[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            A[from].add(new Info(to, wei));
            A[to].add(new Info(from, wei));
        }
    }

    static class Info{
        int to, wei;

        public Info(int to, int wei) {
            this.to = to;
            this.wei = wei;
        }
    }

    static class Node{
        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}