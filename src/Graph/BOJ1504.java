package Graph;

import java.io.*;
import java.util.*;

public class BOJ1504 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int dist[][];
    static ArrayList<Node> node[];
    static int nV, nE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = atoi(st.nextToken());
        nE = atoi(st.nextToken());

        dist = new int[nV + 1][3];
        node = new ArrayList[nV + 1];

        for (int i = 0; i <= nV; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            node[from].add(new Node(to, wei));
            node[to].add(new Node(from, wei));
        }

        st = new StringTokenizer(br.readLine());

        int first = atoi(st.nextToken()); //지나야하는 노드1
        int sec = atoi(st.nextToken()); //지나야하는 노드2

        dijkstra(1, 0); //정점 1에서 시작하는 다익스트라 정보
        dijkstra(first,1); //지나야하는 노드1에서 시작하는 다익스트라 정보
        dijkstra(sec, 2); //지나야하는 노드2에서 시작하는 다익스트라 정보

        int sum1 = -1, sum2 = -1;
        if (dist[first][0] != Integer.MAX_VALUE && dist[sec][1] != Integer.MAX_VALUE &&
                dist[nV][2] != Integer.MAX_VALUE) {
            sum1 = dist[first][0] + dist[sec][1] + dist[nV][2];
        }

        if (dist[sec][0] != Integer.MAX_VALUE && dist[first][2] != Integer.MAX_VALUE &&
                dist[nV][1] != Integer.MAX_VALUE) {
            sum2 = dist[sec][0] + dist[first][2] + dist[nV][1];
        }

        int rel = Math.min(sum1, sum2);

        System.out.println(rel);
    }

    static void dijkstra(int start, int order) {

        for (int i = 1; i <= nV; i++) {
            dist[i][order] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2)->{
            return o1.dist - o2.dist;
        });

        pq.offer(new Info(start, 0));
        dist[start][order] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if(info.dist != dist[info.idx][order]) continue;

            for (Node n : node[info.idx]) {

                if(dist[info.idx][order] + n.wei >= dist[n.to][order]) continue;

                dist[n.to][order] = dist[info.idx][order] + n.wei;
                pq.add(new Info(n.to, dist[n.to][order]));
            }
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
