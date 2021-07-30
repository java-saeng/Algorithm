package Graph;

//BOJ 1325 효율적인 해킹

/*
이 문제는 할 때마다 시간 초과가 나올 수도 있고, 맞았습니다라고 뜬다.
이 경우는 시간 복잡도가 코드 제한시간에 걸쳐서 제출했을 때, 되는 경우도 있고, 안 되는 경우도 있다고들 한다.
비록 많은 문제를 풀진 않았지만 이런 경우도 있다고들 한다.

문제는 일반 dfs와 풀이식이 비슷한 것 같았다. 다만 헷갈리는 점이 있었다.
A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다.
문제에서는 3 1 / 3 2 이런 식으로 주어졌는데, 보자마자 거꾸로 생각해야하는 문제인가 보다 했다. 그래서 그래프 모양을
이렇게 표현했었다. 그리고 코드를 돌려보니 값이 1,2가 나오지 않고 4,5가 나온다. 나만 바꿔 생각한 건진 몰라도, 속임수 같아 보였다.
 3 1 이 1을 해킹하면 3도 해킹할 수 있다는 뜻인데, 그래서 1을 해킹하면 3,4,5도 해킹할 수 있어서 그렇게 생각을 한 것 같다.
 그러면 4,5번 노드를 3번 방문하기 때문에 출력을 4,5번이 될 수밖에 없다. 그래서 이 문제는 어느 노드가 가장 해킹을 많이 하는지를 물어보는 뜻이, 방문 횟수가 가장 많은 노드를 출력하면 된다.
 */

import java.io.*;
import java.util.*;

public class BOJ1325 {
    static int nV; //정점의 개수
    static int nE; //간선의 개수
    static boolean[] visit; //방문 배열
    static ArrayList<Integer> []fc;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());

        cnt = new int[nV+1];
        fc = new ArrayList[nV+1];

        for(int i = 1; i <= nV; i++){
            fc[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            fc[t1].add(t2);
        }

        for(int i = 1; i <= nV; i++) {
            visit = new boolean[nV+1];
            dfs(i);
        }


        StringBuilder sb = new StringBuilder();

        int max = 0;

        for(int i = 1; i <= nV; i++){
            if(cnt[i] > max)
                max = cnt[i];
        }

        for(int i = 1; i <= nV; i++){
            if(max == cnt[i])
                sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }


    static void dfs(int n){
        visit[n] = true;
        for( int index : fc[n]){
            if(!visit[index]){
                cnt[index]++;
                dfs(index);
            }
        }
    }
}