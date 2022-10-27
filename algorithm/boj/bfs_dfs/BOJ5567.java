package boj.bfs_dfs;

//BOJ 5567 결혼식

/*이 문제는 상근이의 친구, 친구의 친구만을 초대하는 문제이다. 그래서 촌수 계산과 비슷하게 문제를 풀었다.
여기서는 촌수가 1이거나 2일 때의 사람을 구한다고 생각하면 된다. 즉, 간선이 한 번만 거쳐간 곳, 간선이 두 번 거쳐간 곳만 초대하는 것이다.
그래서 limit배열에 그 사람의 index에 간선이 지나간 횟수를 더하고, 그 index의 value가 1이거나 2일 때만 출력해준다.
 */

import java.io.*;
import java.util.*;

public class BOJ5567 {
    static int n,m;
    static boolean visit[];
    static ArrayList<Integer> ad[];
    static int limit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        ad = new ArrayList[n+1];
        visit = new boolean[n+1];
        limit = new int[n+1];
        for(int i = 0; i < ad.length; i++)
            ad[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            ad[s1].add(s2);
            ad[s2].add(s1);
        }

        bfs(1);

        for(int i = 0; i < limit.length; i++){
            if(limit[i] == 1 || limit[i] == 2)
                count++;
        }

        System.out.println(count);
    }

    //1. 상근이 번호가 1이므로 1의 index들은 모두 초대한다고 생각
    //2, 1의 index들 중에 그들의 친구들도 모두 초대

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;
        while(!q.isEmpty()){
            x = q.poll();
            for(int element : ad[x]){
                if(!visit[element]){
                    visit[element] = true;
                    q.offer(element);
                    limit[element] = limit[x] + 1;
                }
            }
        }
    }
}
