package Graph;

//BOJ 2644 촌수계산

/*
예제 트리를 만들어 보면 이런 식으로 그려진다.
처음에는 큐에서 poll할 경우에 count++을 해주었다.
그러면 7->2에 간 뒤에, 2와 인접한 8, 9, 1을 모두 큐에 집어넣기 때문에 촌수를 구하는데 문제가 생기게 된다.
그래서 count를 배열로 만들어 그에 해당하는 index에 +1을 해주는 방식으로 문제를 풀었다.
 */

import java.io.*;
import java.util.*;

public class BOJ2644 {
    static int start, end;
    static int ad[][];
    static boolean visit[];
    static int count[];
    static int nV;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int nE = Integer.parseInt(st.nextToken());

        ad = new int[nV+1][nV+1];
        visit = new boolean[nV+1];
        count = new int[nV+1];

        for(int i = 0; i < nE; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            ad[s1][s2] = ad[s2][s1] = 1;
        }

        System.out.println(bfs(start,end));

        for(int i : count)
            System.out.print(i + " ");
    }

    static int bfs(int s, int e){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visit[s] = true;
        while(!q.isEmpty()){
            int element = q.poll();
            for(int i = 0; i <= nV; i++){
                if(ad[element][i] == 1 && !visit[i]){
                    visit[i] = true;
                    q.offer(i);
                    count[i] = count[element] + 1; /////
                }
            }
        }
        if(count[e] == 0)
            return -1;

        else
            return count[e];
    }
}
