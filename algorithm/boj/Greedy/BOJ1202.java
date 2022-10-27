package boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202 {
    static int atoi(String string) {
        return Integer.parseInt(string);
    }
    static int N, K;
    static Info A[];
    static int bag[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
       return o2 - o1;
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());

        A = new Info[N];
        bag = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int wei = atoi(st.nextToken());
            int price = atoi(st.nextToken());
            A[i] = new Info(wei, price);
        }

        for (int i = 0; i < K; i++) {
            bag[i] = atoi(br.readLine());
        }

        Arrays.sort(A);
        Arrays.sort(bag);

        pro();
    }

    private static void pro() {
        int idx = 0;
        long sum = 0L;
        for (int i = 0; i < K; i++) {
            while(idx < N && A[idx].wei <= bag[i]){
                pq.offer(A[idx].price);
                idx++;
            }
            if(!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);
    }


    static class Info implements Comparable<Info> {
        int wei, price;

        public Info(int wei, int price) {
            this.wei = wei;
            this.price = price;
        }

        @Override
        public int compareTo(Info o1) {
            return this.wei - o1.wei;
        }
    }
}
