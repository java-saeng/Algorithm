package Data_Structure;

//BOJ 10845 큐

//https://c-king.tistory.com/

/*
컬렉션 큐를 사용하고 풀고 있었는데, back이 가장 뒤에 있는 정수를 출력하라고 해서 pollLast가 있는 덱으로 바꾸어 풀었다.
큐는 이러한 메소드도 없고, 인덱스도 존재하지 않아 back을 출력하는데 어려움이 있다고 생각이 들었다. 그래서 덱을 사용하였다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new ArrayDeque<>();

        int cnt = Integer.parseInt(st.nextToken());

        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str){
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!q.isEmpty()) sb.append(q.poll()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(!q.isEmpty()) sb.append(q.peekFirst()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "back":
                    if(!q.isEmpty()) sb.append(q.peekLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
