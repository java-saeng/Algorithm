package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11000 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static Subject A[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new Subject[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = atoi(st.nextToken());
            int end = atoi(st.nextToken());
            A[i] = new Subject(start, end);
        }

        Arrays.sort(A);

        pro();

    }

    static void pro() {
        pq.offer(A[0].ed);

        for (int i = 1; i < N; i++) {
            if (A[i].st >= pq.peek()) {
                pq.poll();
            }
            pq.offer(A[i].ed);
        }

        System.out.println(pq.size());
    }

    static class Subject implements Comparable<Subject>{
        int st, ed;

        public Subject(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Subject o) {
            return this.st - o.st;
        }
    }
}

