package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21278 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static ArrayList<Integer> A[];
    static int select[] = new int[2];
    static int ans = Integer.MAX_VALUE;
    static int build1, build2;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        dfs(1, 0);

        ans = ans * 2; //왕복

        System.out.println(build1 + " " + build2 + " " + ans);
    }

    static void dfs(int start, int cnt) {
        if(cnt == 2){
            bfs();
            return;
        }

        for (int i = start; i <= N; i++) {

            select[cnt] = i;
            dfs(i + 1, cnt + 1);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(select[0]);
        q.offer(select[1]);

        int dist[] = new int[N + 1];
        boolean visit[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        dist[select[0]] = 0;
        dist[select[1]] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int k : A[x]) {
                if(dist[k] > dist[x] + 1) dist[k] = dist[x] + 1;
                if(visit[k]) continue;
                q.offer(k);
                visit[k] = true;
            }
        }
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }

        //여기서 같다라고 하지 않은 이유는
        //문제에서 건물 번호가 낮을 수록 좋다고 함.
        //어차피 조합에서 건물 낮은 얘들부터 뽑히니까 그런거임
        if(ans > sum){
            ans = sum;
            build1 = select[0];
            build2 = select[1];
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = atoi(st.nextToken());
            int e = atoi(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }
    }
}
