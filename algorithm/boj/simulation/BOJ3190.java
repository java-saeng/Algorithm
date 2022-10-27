package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, K, L, ans;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    //->방향이 0부터 시계방향으로 1, 2, 3
    static boolean apple[][];
    static int order[];
    public static void main(String[] args) throws IOException {
        input();
        pro();

        System.out.println(ans+1);
    }

    static void pro() {
        Deque<Info> dq = new ArrayDeque<>();
        dq.offer(new Info(0, 0, 0));

        while (!dq.isEmpty()) {
            Info info = dq.peekFirst();

            if(order[ans] == 1){
                info.status = (info.status + 1) % 4;
            }
            else if(order[ans] == -1){
                info.status = (info.status - 1 + 4) % 4;
            }

            int nextX = info.x + dx[info.status];
            int nextY = info.y + dy[info.status];

            if(!isRangeTrue(nextX, nextY)) return;
            if(isContain(dq, nextX, nextY)) return;

            dq.offerFirst(new Info(nextX, nextY, info.status));
            ans++;

            if(apple[nextX][nextY]){
                apple[nextX][nextY] = false;
            }
            else{
                dq.pollLast();
            }
        }
    }

    static boolean isContain(Deque<Info> dq, int x, int y) {
        for (Info info : dq) {
            if(info.x == x && info.y == y) return true;
        }
        return false;
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = atoi(br.readLine());

        K = atoi(br.readLine());

        apple = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = atoi(st.nextToken());
            int y = atoi(st.nextToken());
            apple[x-1][y-1] = true;
            //문제에서 1,1 부터 시작한다
            //나는 0,0 부터 시작이기 때문에 사과의 좌표를 하나씩 땅겨줘야한다.
        }

        L = atoi(br.readLine());
        order = new int[10001];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = atoi(st.nextToken());
            String dir = st.nextToken();

            switch (dir){
                case "D":
                    order[time] = 1;
                    break;
                case "L":
                    order[time] = -1;
                    break;
            }
        }

    }



    static class Info{
        int x, y, status;

        public Info(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }
}