package DFS;

//BOJ 1926 그림

/*
이 문제 또한 전에 풀었던 음식물 피하기 문제와 매우 유사하다. 다른 점이 있다면 크기뿐만 아니라 컴포넌트의 개수까지 구하라고 했다.
컴포넌트는 dfs를 시작하는 코드 안에 변수 하나를 증가시켜주면 구하기 쉽다. 그래서 이 문제를 푸는 데에 큰 어려움은 없었다.
 */

import java.net.Inet4Address;
import java.util.*;
import java.io.*;
public class BOJ1926{
    static int n,m;
    static int [][] ad;
    static boolean [][] visit;
    static int draw_size;     //그림의 크기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int component = 0;  //그림의 개수 변수
        int draw_max_size = 0;
        ad = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                ad[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs 시작
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                draw_size = 0;
                if(!visit[i][j] && ad[i][j] == 1) {
                    draw_size = dfs(i,j);
                    if (draw_max_size < draw_size)
                        draw_max_size = draw_size;
                    component++;
                }
            }
        }
        System.out.println(component);
        System.out.println(draw_max_size);
    }

    static int dfs(int x,int y){
        visit[x][y] = true;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];

            if(isRangeTrue(row,col) && !visit[row][col] && ad[row][col] == 1) {
                dfs(row, col);
                draw_size++;
            }
        }
        return draw_size+1;
    }

    static boolean isRangeTrue(int x, int y){
        return x > 0 && x <= n && y > 0 && y <= m;
    }
}