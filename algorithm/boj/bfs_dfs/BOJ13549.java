package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ13549 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N,K;
    static int time[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {

        for (int i = 0; i <= 100000; i++) time[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->{
            return o1.compareTo(o2);
        });

        pq.offer(new Info(N, 0));
        time[N] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if(isRangeTrue(info.x + 1) && time[info.x + 1] > info.cnt + 1){
                time[info.x + 1] = info.cnt + 1;
                pq.offer(new Info(info.x + 1, info.cnt + 1));
            }

            if(isRangeTrue(info.x - 1) && time[info.x - 1] > info.cnt + 1){
                time[info.x - 1] = info.cnt + 1;
                pq.offer(new Info(info.x - 1, info.cnt + 1));
            }

            if(isRangeTrue(info.x * 2) && time[info.x * 2] > info.cnt){
                time[info.x * 2] = info.cnt;
                pq.offer(new Info(info.x * 2, info.cnt));
            }

        }

        System.out.println(time[K]);

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());
        time = new int[100001];
    }

    static boolean isRangeTrue(int x) {
        return x >= 0 && x <= 100000;
    }

    static class Info implements Comparable<Info>{
        int x, cnt;

        public Info(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            return this.cnt - o.cnt;
        }
    }
}

/*
import java.io.*;
import java.util.*;

public class Main {
    static int atoi(boj.String str) {
        return Integer.parseInt(str);
    }
    static int N,K;
    static boolean visit[];
    static int min = Integer.MAX_VALUE;

    public static void main(boj.String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(N, 0));
        visit[N] = true;

        while (!q.isEmpty()) {
            Info info = q.poll();

            if(info.x == K){
                min = boj.Math.min(min, info.cnt);
                continue;
            }

            //아래 두 if문을 이 위치로 해놓으면 틀리다가 나옴

            int num = info.x;
            while (isRangeTrue(num * 2)) {
                if (!visit[num * 2]) {
                    q.offer(new Info(num * 2, info.cnt));
                    visit[num * 2] = true;
                }
                else break;
                num *= 2;
            }

            if(isRangeTrue(info.x + 1) && !visit[info.x + 1]){
                q.offer(new Info(info.x + 1, info.cnt + 1));
                visit[info.x + 1] = true;
            }
            if(isRangeTrue(info.x - 1) && !visit[info.x - 1]){
                q.offer(new Info(info.x - 1, info.cnt + 1));
                visit[info.x - 1] = true;
            }

        }

        System.out.println(min);

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());
        visit = new boolean[100001];
    }

    static boolean isRangeTrue(int x) {
        return x >= 0 && x <= 100000;
    }

    static class Info{
        int x, cnt;

        public Info(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}

*/

