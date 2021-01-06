package DFS;

//BOJ 2667 단지번호 붙이기

/*
이 문제는 컴포넌트와 그 넓이를 구하는 문제로, 전에 풀었던 문제들과 매우 유사하다. 이 문제를 풀면서 고생했던 부분은 입력 부분에서 있었다.
전의 문제들은 행렬로 주어지면서 모두 공백을 예시로 주었다.
그래서 전처럼 StringTokenizer 클래스를 사용하지 않고 String변수 str을 선언해서 버퍼로 입력을 받고
charAt 메소드를 이용해 char형으로 숫자를 뽑아내서 ASCII를 이용해 '0'을 빼주면 정수형으로 값이 나오게 된다.
 */

import java.io.*;
import java.util.*;

public class BOJ2667 {
    static int[][] ad;
    static boolean[][] visit;
    static int N;
    static int component = 0;
    static int[] size_arr;
    static int size;
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ad = new int[N][N];
        visit = new boolean[N][N];
        size_arr = new int[1000];
        int num = 0;
        //입력

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                ad[i][j] = str.charAt(j) - '0';
            }
        }


        //dfs start
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j] && ad[i][j] == 1){
                    size = 1;
                    size_arr[num] = dfs(i,j);
                    component++;
                    num++;
                }
            }
        }
        Arrays.sort(size_arr,0,num);
        System.out.println(component);
        for(int i = 0; i < num; i++)
            System.out.println(size_arr[i]);
    }

    static int dfs(int x, int y){
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(isRangeTrue(row,col) && !visit[row][col] && ad[row][col] == 1){
                dfs(row,col);
                size++;
            }
        }
        return size;
    }

    static boolean isRangeTrue(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
