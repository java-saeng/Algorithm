package boj.Data_Structure;

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
    static int N, K, orderCnt;
    static boolean apple[][];
    static Order order[];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        input();
        pro();

        System.out.println(ans + 1);
    }

    static void pro() {
        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(0, 0, 0));
        //0 : 오른쪽 1: 아래 2 : 왼 3 : 위

        while (!dq.isEmpty()) {
            Point p = dq.peekFirst();

            for (int i = 0; i < orderCnt; i++) {
                if(ans == order[i].time){
                    switch (order[i].dir){
                        case "D":
                            p.status = (p.status + 1) % 4;
                            break;
                        case "L":
                            p.status = (p.status - 1 + 4) % 4;
                            break;
                    }
                }
            }

            int nextX = p.x + dx[p.status];
            int nextY = p.y + dy[p.status];

            if (!isRangeTrue(nextX, nextY) || isEqual(dq, nextX, nextY)){
                return;
            }
            else{
                dq.offerFirst(new Point(nextX, nextY, p.status));
                ans++;
                //사과가 없다면 꼬리 하나 잘라야함.
                if(!apple[nextX][nextY]){
                    dq.pollLast();
                }
                //사과가 있다면 사과 false로
                else{
                    apple[nextX][nextY] = false;
                }
            }
        }
    }

    static boolean isEqual(Deque<Point> dq, int x, int y){
        for (Point p : dq) {
            if(p.x == x && p.y == y) return true;
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
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());

            apple[s1-1][s2-1] = true;
        }

        orderCnt = atoi(br.readLine());
        order = new Order[orderCnt];

        for (int i = 0; i < orderCnt; i++) {
            st = new StringTokenizer(br.readLine());
            order[i] = new Order(atoi(st.nextToken()), st.nextToken());
        }
    }

    static class Point{
        int x, y, status;

        public Point(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }

    }

    static class Order{
        int time;
        String dir;

        public Order(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}
