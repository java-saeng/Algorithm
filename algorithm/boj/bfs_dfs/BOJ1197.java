package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1197 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int V, E;
    static ArrayList<Info> A = new ArrayList<>();
    static int parent[];
    static int ans;
    static int limit;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {

        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            if (findSet(A.get(i).from) != findSet(A.get(i).to)) {
                unionSet(A.get(i).from, A.get(i).to);
                limit++;
                ans += A.get(i).wei;
                if(limit == V - 1) break;
            }
        }

        System.out.println(ans);

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = atoi(st.nextToken());
        E = atoi(st.nextToken());

        parent = new int[V + 1];

        Arrays.fill(parent, -1);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            A.add(new Info(from, to, wei));

        }
    }

    static int findSet(int v) {
        if(parent[v] < 0) return v;
        return findSet(parent[v]);
    }

    static void unionSet(int u, int v) {
        u = findSet(u);
        v = findSet(v);
        if(u == v) return;
        parent[u] += parent[v];
        parent[v] = u;
    }

    static class Info implements Comparable<Info>{

        int from;
        int to;
        int wei;

        public Info(int from, int to, int wei) {
            this.from = from;
            this.to = to;
            this.wei = wei;
        }

        @Override
        public int compareTo(Info o) {
            return this.wei - o.wei;
        }
    }
}