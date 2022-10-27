package boj.bfs_dfs;
//BOJ 2468 안전 영역

/*
이 문제를 풀면서 내가 글을 이해를 못하는 건지, 문제가 이상한 건지라는 생각이 들 정도로 이해가 안 갔다.
물론 문제가 이상한 게 아니라 내가 글을 이해 못하는 게 맞지만 말이다. 아무튼 이 문제는 h에 따른 dfs를 구하는 문제이다.
따라서 삼중 for문을 사용할 수밖에 없다고 사용한다. 물론 다른 방법도 있을 수 있겠지만, dfs로 풀려면 삼중 for문을 써야 한다고 생각한다.
그래서 그 부분 말고 나머지 부분들은 다른 dfs문제들과 다른 점이 없다.
그리고 실수한 부분이 있었다. 처음에 실행했을 때 답이 1 나오길래 코드부분을 다시 살펴보았다.
그러나 코드 부분은 전혀 이상한 게 없는데 도대체 어디서 잘못된 건지 코드를 수차례 검토했다.
자세히 보니 visit 배열을 h가 커질 때마다 초기화해주지 않기 때문에 계속 같은 visit배열로 dfs를 돌리고 있었던 것이다.
그래서 visit를 h가 커질 때마다 초기화해주고 돌려보았더니 맞았다.
 */

import java.util.*;
import java.io.*;
public class BOJ2468 {
    static int N;
    static int ad[][];
    static boolean visit[][];
    static int max_height = 0;  //높이 최대
    static int min_height = 100;  //높이 최저
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max_component = 0; //component 값 중에 최대 component 값 출력해야하는 값
        int component;  //각 dfs가 끝날때마다 return하는 component 값

        N = Integer.parseInt(st.nextToken()); //행렬
        ad = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                ad[i][j] = Integer.parseInt(st.nextToken());
                if(max_height <= ad[i][j]) max_height = ad[i][j];
                if(min_height >= ad[i][j]) min_height = ad[i][j];
            }
        }
        for(int h = min_height-1; h <= max_height; h++) {
            component = 0;
            visit = new boolean[N][N];                      //이 부분 실수 조심해야함.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && ad[i][j] > h) {
                        dfs(i, j, h);
                        component++;
                    }
                }
            }
            if(max_component < component)
                max_component = component;
        }
        System.out.println(max_component);

    }


    static void dfs(int x, int y,int h){
        visit[x][y] = true;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(isRangeTrue(row,col) && !visit[row][col] && ad[row][col] > h)
                dfs(row,col,h);
        }
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
