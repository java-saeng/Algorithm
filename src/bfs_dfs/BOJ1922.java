package bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ1922 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int parent[];
    static int N, M;
    static ArrayList<ComPoint> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        M = atoi(br.readLine());
        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            al.add(new ComPoint(s1, s2, wei));
        }

        Collections.sort(al, (o1, o2) ->  {
            return o1.wei - o2.wei;
        });

        int rel = 0;
        int cnt = 0;
        for (int i = 0; i < al.size(); i++) {
            if(findSet(al.get(i).st) != findSet(al.get(i).ed)){
                rel += al.get(i).wei;
                unionSet(al.get(i).st, al.get(i).ed);
                if(++cnt == N - 1) break;
            }
        }

        System.out.println(rel);
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

    static class ComPoint{
        int st, ed, wei;

        public ComPoint(int st, int ed, int wei) {
            this.st = st;
            this.ed = ed;
            this.wei = wei;
        }
    }
}