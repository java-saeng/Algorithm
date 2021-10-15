package bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ1916 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int nV, nE;
    static ArrayList<Node> node[];
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        nV = atoi(br.readLine());
        nE = atoi(br.readLine());

        node = new ArrayList[nV + 1];
        dist = new int[nV + 1];

        for (int i = 0; i <= nV; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            node[from].add(new Node(to, wei));
        }

        st = new StringTokenizer(br.readLine());
        int start = atoi(st.nextToken());
        int end = atoi(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= nV; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.dist - o2.dist;
        });

        pq.offer(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll(); //info에는 현재 정점이 저장

            if(dist[info.idx] != info.dist) continue;

            for (Node n : node[info.idx]) {
                if(dist[n.to] <= dist[info.idx] + n.wei) continue; //n.to는 연결된곳

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
