package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21317 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, k, ans = Integer.MAX_VALUE;
    static int jump[][];

    static class Stone{
        int n, sum;
        boolean flag;

        public Stone(int n, int sum, boolean flag) {
            this.n = n;
            this.sum = sum;
            this.flag = flag;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());

        jump = new int[N + 1][2];

        for(int i = 1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int small = atoi(st.nextToken());
            int big = atoi(st.nextToken());
            jump[i][0] = small;
            jump[i][1] = big;
        }

        k = atoi(br.readLine());

        bfs();
    }

    static void bfs() {
        Queue<Stone> q = new ArrayDeque<>();
        q.offer(new Stone(1, 0, false));

        while (!q.isEmpty()) {
            Stone s = q.poll();

            if(s.n > N) continue;

            if(s.n == N){
                ans = Math.min(ans, s.sum);
                continue;
            }


            q.offer(new Stone(s.n + 2, s.sum + jump[s.n][1], s.flag));
            q.offer(new Stone(s.n + 1, s.sum + jump[s.n][0], s.flag));

            if(s.flag == false) {
                q.offer(new Stone(s.n + 3, s.sum + k, true));
            }
        }

        System.out.println(ans);
    }
}