package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1647 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static ArrayList<Info> al = new ArrayList<>();
    static int parent[];
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Collections.sort(al, (o1, o2)->{
           return o1.wei - o2.wei;
        });

        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < al.size(); i++) {
            Info info = al.get(i);
            if (find(info.st) != find(info.ed)) {
                union(info.st, info.ed);
                ans += info.wei;
                max = boj.Math.max(max, info.wei);
                if(++cnt == N-1) break;
            }
        }

        System.out.println(ans - max);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            al.add(new Info(from, to, wei));
        }
    }

    static int find(int v) {
        if(parent[v] < 0) return v;
        parent[v] = find(parent[v]);

        return parent[v];
    }

    static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return;

        parent[u] = v;
    }

    static class Info{
        int st, ed, wei;

        public Info(int st, int ed, int wei) {
            this.st = st;
            this.ed = ed;
            this.wei = wei;
        }
    }
}
