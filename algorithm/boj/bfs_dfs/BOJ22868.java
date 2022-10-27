package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ22868 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static ArrayList<Integer> A[];
    static boolean visit[];
    static int realVisit[]; //실제 지나왔던 경로 저장
    static int start, end, ans;
    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(ans);
    }

    static void pro() {
        for (int i = 1; i <= N; i++) Collections.sort(A[i]);

        bfs(start, end);
        for(int i = 1; i <= N; i++) visit[i] = false;

        int last = realVisit[end];
        while(last > 0){
            visit[last] = true;
            last = realVisit[last];
        }

        bfs(end, start);
    }

    static void bfs(int st, int ed) {
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(st, 0));
        visit[st] = true;

        while (!q.isEmpty()) {
            Info info = q.poll();

            ///////////////////이 부분

           for (int node : A[info.idx]) {
                if(!visit[node]){
                    visit[node] = true;
                    realVisit[node] = info.idx;
                    q.offer(new Info(node, info.cnt + 1));
                }

                if(node == ed){ //처음에 전역변수인 end라함.
                    ans += info.cnt + 1;
                    return;
                }

            /*
            2.
                if(node == ed){
                    ans += info.cnt + 1;
                    return;
                }

                if(visit[node]) continue;

                q.offer(new Info(node, info.cnt + 1));
                visit[node] = true;
                //지나왔던 경로 저장
                realVisit[node] = info.idx;*/
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        visit = new boolean[N + 1];
        realVisit = new int[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) A[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());

            A[from].add(to);
            A[to].add(from);
        }

        st = new StringTokenizer(br.readLine());

        start = atoi(st.nextToken());
        end = atoi(st.nextToken());
    }

    static class Info{
        int idx, cnt;

        public Info(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}