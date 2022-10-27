package boj.bfs_dfs;

//BOJ 2644 촌수 계산

/*
이 문제를 풀면서 가장 생각하기 어려웠던 부분이 dfs인자로 cnt를 넣는 부분이다.
문제 예시에서는 7 과 3의 촌수 관계를 나타낸다. 그래서 7 - 2 - 1 - 3 이 한 번에 가기 때문에 촌수 관계가 3이 나온다.
만약에 3과 7이 아니라 8과 3이라면 3 - 1 - 2 - 7 - 8을 가게 돼서 촌수 관계가 4가 나오게 된다. 촌수 관계는 3인데 말이다.
처음에는 dfs 메소드가 돌아갈 때마다 result++을 해주었다. 그래서 이 부분을 어떻게 해결해야 하나 무척 고민을 많이 하였다. 백트레킹을 생각해보았는데 이건 아닌 것 같았다.
그래서 구글링을 해서 힌트를 얻고자 했다. 그랬더니 dfs인자에 cnt를 넣어주는 것이었다. 이게 정말 기발하다고 생각한 이유가 만약에 7 아래 다른 노드가 존재한다고 생각해보자.
그러면 3 - 1 - 2 - 7 - 새로운 노드에 들어가서 원하는 노드를 찾지 못하고 돌아올 때, dfs메소드 인자에 cnt가 존재하기 때문에 그 해당 dfs(2)로 돌아온다면 cnt는 그대로 2일 것이다.
이게 무슨 말인지 모르겠다면 다시 생각해보자.
처음에 (3,0) -> (1,1) -> (2,2) -> (7,3) 이런식으로 dfs메소드가 실행된다. 만약에 7 노드가 찾는 게 아니라면 우리는 다시 (2,2)에 들어가서 다시 (8,3) 이런 식으로 들어가게 된다.
만약에 result++을 해준다면 4가 되었을 것이다. 따라서 dfs메소드 인자에 cnt를 넣어주는 생각이 기발하다고 생각한다.
 */

import java.util.*;
import java.io.*;

public class BOJ2644_dfs {
    static ArrayList<Integer> [] ad;
    static boolean[] visit = new boolean[101];
    static int nV, nE;
    static int n, m;
    static int result = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());  //총 n 명

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //구해야하는 부모번호
        m = Integer.parseInt(st.nextToken());   //구해야하는 자식번호

        st = new StringTokenizer(br.readLine());
        nE  = Integer.parseInt(st.nextToken());

        ad = new ArrayList[nV+1];

        for(int i = 1; i <= nV; i++){
            ad[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < nE; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            ad[t1].add(t2);
            ad[t2].add(t1);
        }
        dfs(n,0);
        System.out.print(result);
    }

    public static void dfs(int start,int cnt){
        visit[start] = true;
        for(int index : ad[start]){
            if(!visit[index]){
                if( index == m){
                    result = cnt+1;
                    return;
                }
                dfs(index,cnt+1);
            }
        }
    }
}