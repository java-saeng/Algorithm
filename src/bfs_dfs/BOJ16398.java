package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ16398 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static int parent[];
    static ArrayList<Info> al = new ArrayList<>();
    static long ans;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Collections.sort(al, (o1, o2)->{
           return o1.wei - o2.wei;
        });

        int cnt = 0;

        for (int i = 0; i < al.size(); i++) {
            Info info = al.get(i);

            if (find(info.st) != find(info.ed)) {
                union(info.st, info.ed);
                ans += info.wei;
                if(++cnt == N - 1) break;
            }
        }

        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < i; k++) st.nextToken();
            for (int j = i; j < N; j++) {
                int wei = atoi(st.nextToken());
                al.add(new Info(i, j, wei));
            }
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
