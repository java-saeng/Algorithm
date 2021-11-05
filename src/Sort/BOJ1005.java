package Sort;

import java.io.*;
import java.util.*;

public class BOJ1005 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, K;
    static int build[];
    static int target;
    static ArrayList<Integer> A[];
    static int deg[];
    static int time[];
    static ArrayList<Integer> B[];
    public static void main(String[] args) throws IOException {
        input();
    }

    static void pro() {
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            if (deg[i] == 0) {
                q.offer(i);
                time[i] = build[i];
            }
        }


        while (!q.isEmpty()) {
            int m = q.poll();

            for(int n : A[m]){
                deg[n]--;
                if(deg[n] == 0) {
                    q.offer(n);
                    for(int z : B[n]){
                        time[n] = Math.max(time[z] + build[n], time[n]);
                    }
                }
            }
        }

        System.out.println(time[target]);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = atoi(br.readLine());

        while (test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = atoi(st.nextToken());
            K = atoi(st.nextToken());

            build = new int[N + 1];
            A = new ArrayList[N + 1];
            B = new ArrayList[N + 1];
            time = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                A[i] = new ArrayList<>();
                B[i] = new ArrayList<>();
            }
            deg = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) build[i] = atoi(st.nextToken());

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int s = atoi(st.nextToken());
                int e = atoi(st.nextToken());

                A[s].add(e);
                B[e].add(s);
                deg[e]++;
            }

            target = atoi(br.readLine());

            pro();
        }
    }
}
