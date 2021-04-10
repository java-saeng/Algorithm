package Data_Structure;

//BOJ 1158 요세푸스 문제

/*
문제에 처음 접근했을 때는 원형 큐를 생각했다. 그래서 처음 index를 -1로 설정하고, (index + K) % q.size()로 풀려고 했다.
하지만 해당 index의 값을 삭제할 순 없었고, 0으로 설정을 했는데 index가 그대로 남아 0인 부분을 뛰어넘을 수 없어서 답이 나오질 않았다.
다시 생각해보니 큐를 만들고, 제일 앞의 두 개를 뒤로 넘기면 제일 앞에 있는 숫자가 3번째 숫자임을 깨달았다.
1 2 3 4 5 6 7 에서 1 2 를 뒤로 보낸다.
3 4 5 6 7 1 2 에서 poll()을 사용하면 3이 나오게 된다.
4 5 6 7 1 2 에서 또 4 5 를 뒤로 보낸다.
6 7 1 2 4 5 에서 poll()을 사용하면 6이 나오게 된다.
그래서 이 방법을 생각하고 while(!q.isEmpty())를 사용했는데, 출력에서 문제가 생겼다. 왜냐하면 큐가 비어있을 때까지 출력을 하게 되면 마지막 출력 값이 4, > 이런 식으로 나왔다.
그래서 q.size() != 1로 바꾸고, 마지막 데이터는 q.poll() 하고 ">"을 해주었다.
 */

import java.io.*;
import java.util.*;

public class BOJ1158 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int limit = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        sb.append("<");

        for(int i = 1; i <= limit; i++)
            q.offer(i);

        while(q.size() != 1){
            for(int i = 0; i < start-1; i++){
                int num = q.poll();
                q.offer(num);
            }
            sb.append(q.poll() +  ", ");
        }

        sb.append(q.poll() + ">");
        System.out.print(sb);
    }
}
