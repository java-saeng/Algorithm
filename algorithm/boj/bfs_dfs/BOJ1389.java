package boj.bfs_dfs;

// BOJ 1389 케빈 베이컨의 6단계 법칙

/*
이 문제를 풀면서 가장 중요한 부분이 이 케빈 베이컨의 개수를 어떻게 저장하냐인 것 같다.
그래서 나는 1의 케빈 베이컨은 count 배열의 1행에, 2는 count배열의 2행에 저장하는 방식으로 사용하였다.
그래서 bfs while문을 보게 되면 count[start][i] = count[start][cur] + 1 이런식으로 나타내어 문제를 해결했다.
 */

import java.io.*;
import java.util.*;

public class BOJ1389 {
    static int nV, nE;
    static int ad[][];
    static boolean visit[];
    static int count[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());

        ad = new int[nV+1][nV+1];
        int sum[] = new int[nV+1];
        count = new int[nV+1][nV+1];
        int indexvalue = Integer.MAX_VALUE;
        int index = 0;

        for(int i = 0; i < nE; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            ad[s1][s2] = ad[s2][s1] = 1;
        }

        for(int i = 1; i <= nV; i++){
            visit = new boolean[nV+1];
            bfs(i);
        }

        for(int i = 1; i <= nV; i++){
            for(int j = 1; j <= nV; j++){
                sum[i] += count[i][j];
            }
        }

        for(int i = 1; i <= nV; i++){
            if(sum[i] < indexvalue){
                indexvalue = sum[i];
                index = i;
            }
        }

        System.out.print(index);
    }
    //1. 만약 1번 노드의 케빈 베이컨을 구하려면 count[1][0~5] 에 저장을 함.
    //2. 2번 노드이면 count[2][0~5] 에 저장을 함. 그래서 count[1~5][0~5] 를 다 더해서 최소값을 구하는 거임. 그 중에
    //3. 앞의 index값을 출력하면 됨 거기서 break하면 될듯.

    //1. count[start] 라고 생각하면될듯
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= nV; i++) {
                if (!visit[i] && ad[cur][i] == 1) {
                    q.offer(i);
                    visit[i] = true;
                    count[start][i] = count[start][cur] + 1;
                }
            }
        }
    }
}
