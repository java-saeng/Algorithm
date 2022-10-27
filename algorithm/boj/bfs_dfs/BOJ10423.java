package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ10423 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M, K;
    static int parent[];
    static ArrayList<Info> al = new ArrayList<Info>();
    static int ans;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Collections.sort(al, (o1, o2)->{
            return o1.wei - o2.wei;
        });

        for (int i = 0; i < al.size(); i++) {
            Info info = al.get(i);
            if (find(info.st) != find(info.ed)) {
                union(info.st, info.ed);
                ans += info.wei;

                if(check()) break;
            }
        }

       /* for (int i = 1; i <= N; i++) {
            System.out.println(parent[i]);
        }*/
        System.out.println(ans);
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            if(parent[i] >= 0) {
                return false;
            }
        }

        return true;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        K = atoi(st.nextToken());

        parent = new int[N + 1];

        Arrays.fill(parent, 0);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int num = atoi(st.nextToken());
            parent[num] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            al.add(new Info(from, to, wei));
        }
    }

    static int find(int v) {
        if(parent[v] < 0) return -1;
        if(parent[v] == 0) return v;

        parent[v] = find(parent[v]);

        return parent[v];
    }

    static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return;

        if(u == -1){
            parent[v] = -1;
        }
        else if(v == -1){
            parent[u] = -1;
        }
        else{
            parent[v] = u;
        }
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
