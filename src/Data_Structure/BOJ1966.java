package Data_Structure;

//BOJ 1966 프린터 큐

/*
문제에 처음 접근했을 때, priority라는 배열에 우선순위를 저장하고, q에는 문서를 0부터 넣는다.(문제에서 문서 제일 왼쪽을 0이라 함)
그리고 target은 index로 생각했다. 세 번째 태케로 예를 들면,
큐 :             0 1 2 3 4 5
priority 배열 :   1 1 9 1 1 1
index        :   0 1 2 3 4 5
target : 0
target은 index를 가리킨다. 따라서
1. findMax() 를 통해 priority 배열에서 가장 큰 우선순위를 얻는다.
2. 큐에서 poll 한 값을 element에 저장한다.
2-1. 만약에 priority[element]가 가장 큰 우선순위라면 q에서 빼냈으므로 cnt를 1 증가시키고,
 다음 max값을 구하는데 오류가 나지 않으려면 해당 우선순위를 0으로 만들어준다.
2-2. 만약 target과 element 가 같으면 sb에 cnt값을 넣어주고, 반복문을 나온다.
3. 만약에 priority[element]가 max와 같지 않으면 poll 하면 안 되기 때문에 제일 뒤로 보내준다.
그래서 q.offer(element)를 한다.

이 문제를 풀면서 헷갈렸던 점이 우선순위를 어디에 저장해야하고, priority는 배열인데 뒤로 어떻게 빼내지라는 생각을 했는데 문제를 자세히 읽어보니 문서의 제일 왼쪽은 0부터 시작한다 해서 배열처럼 생각해서 index가 0부터 시작한다고 생각했다.
그래서 문서 번호와 index를 일치시키고, priority값이 max와 같으면 poll 한 것을 그대로 내버려두고, 만약 이 index가 target과 같게 되면 출력을 하게 되고 반복문 끝을 낸다.
 */

import java.io.*;
import java.util.*;

public class BOJ1966 {
    static int[] priority;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(st.nextToken());


        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());
            int doccnt = Integer.parseInt(st.nextToken()); //문서의 갯수
            int target = Integer.parseInt(st.nextToken()); //타겟 인덱스
            st = new StringTokenizer(br.readLine());
            priority = new int[doccnt];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < doccnt; i++) {
                priority[i] = Integer.parseInt(st.nextToken()); //문서 우선순위를 배열에 저장.
                q.offer(i);   //큐에 문서
            }
            int cnt = 0;
            while(true){
                int max = findMax();
                int element = q.poll();
                if(max == priority[element]){
                    cnt++;
                    priority[element] = 0;
                    if(target == element){
                        sb.append(cnt).append('\n');
                        break;
                    }
                }
                else{
                    q.offer(element);
                }
            }
        }
        System.out.print(sb);
    }
    public static int findMax(){
        int max = 0;
        for(int i = 0; i < priority.length; i++){
            if(max < priority[i]) max = priority[i];
        }
        return max;
    }
}