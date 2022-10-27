package boj.Data_Structure;

import java.util.*;

public class BOJ2164 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= end; i++){
            dq.offer(i);
        }

        while(dq.size() != 1){
            dq.pollFirst();
            int element = dq.pollFirst();
            dq.offer(element);
        }

        System.out.println(dq.poll());
    }
}
