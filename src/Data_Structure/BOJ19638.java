package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ19638 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static int std; //기준 키
    static int limit; //망치 제한
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
        return o2.compareTo(o1);
    });
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        std = atoi(st.nextToken());
        limit = atoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            pq.offer(atoi(br.readLine()));
        }

        pro();

        System.out.println(sb);
    }

    static void pro() {
        for (int i = 0; i < limit; i++) {

            int num = pq.peek();

            if(num < std) {
                sb.append("YES" + "\n" + i);
                return;
            }

            else if(num > 1){
                pq.poll();
                pq.offer(num / 2);
            }
        }
//
//        for (Integer integer : pq) {
//            System.out.println(integer);
//        }
        if(pq.peek() >= std) sb.append("NO").append("\n").append(pq.peek());
        else sb.append("YES").append("\n").append(limit);
    }
}