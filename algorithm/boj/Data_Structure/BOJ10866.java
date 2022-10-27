package boj.Data_Structure;

//BOJ 10866 덱

// https://c-king.tistory.com/

/*
덱의 메소드를 알면 쉽게 풀 수 있는 문제이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10866 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        int cnt = Integer.parseInt(st.nextToken());

        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str){
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if(!dq.isEmpty()) sb.append(dq.pollFirst()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "pop_back":
                    if(!dq.isEmpty()) sb.append(dq.pollLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "size" :
                    sb.append(dq.size()).append('\n');
                    break;
                case "empty" :
                    if(dq.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.peekFirst()).append('\n');
                    break;
                case "back":
                    if(!dq.isEmpty()) sb.append(dq.peekLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
