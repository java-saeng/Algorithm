package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ1753 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static final int INF = Integer.MAX_VALUE;
    static int nV, nE;
    static ArrayList<Node> node[];
    static int dist[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        nV = atoi(st.nextToken());
        nE = atoi(st.nextToken());

        node = new ArrayList[nV + 1];
        dist = new int[nV + 1];

        for (int i = 0; i <= nV; i++) {
            node[i] = new ArrayList<>();
        }

        int start = atoi(br.readLine());

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            node[from].add(new Node(to, wei));
        }

        dijkstra(start);

        for (int i = 1; i <= nV; i++) {
            if(dist[i] == INF){
                sb.append("INF").append("\n");
                continue;
            } else sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2)->{
            return o1.dist - o2.dist;
        });

        for(int i = 0; i <= nV; i++) dist[i] = INF;

        pq.offer(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if(info.dist != dist[info.idx]) continue;

            for (Node n : node[info.idx]) {
                if(dist[n.to] <= dist[info.idx] + n.wei) continue;

                dist[n.to] = dist[info.idx] + n.wei;
                pq.offer(new Info(n.to, dist[n.to]));
            }
        }
    }
    static class Info{
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static class Node{
        int to, wei;

        public Node(int to, int wei) {
            this.to = to;
            this.wei = wei;
        }
    }
}