package Graph;

//BOJ 13565 침투
import java.util.*;
import java.io.*;

public class BOJ13565 {
    static char arr[][];
    static boolean visit[][];
    static int N, M;
    static Queue<Penetration> q = new ArrayDeque<>();
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken()); //가로
        M = atoi(st.nextToken()); //세로

        arr = new char[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j);
                if(i == 0) q.offer(new Penetration(i, j)); //outside를 큐에 다 넣음
            }
        }
        ////////////////////////////입력 끝

        bfs();
        boolean flag = false;
        for(int i = 0; i < M; i++){
            if(visit[N-1][i]){
                flag = true;
                break;
            }
        }
        if(flag) System.out.print("YES");
        else System.out.print("NO");
    }
    static boolean isRangeTrue(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
    static void bfs(){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        while(!q.isEmpty()){
            Penetration pt = q.poll();
            visit[pt.x][pt.y] = true;
            for(int i = 0; i < 4; i++){
                int X = pt.x + dx[i];
                int Y = pt.y + dy[i];
                if(!isRangeTrue(X, Y)) continue;
                if(visit[X][Y]) continue;

                if(arr[X][Y] == '0'){
                    q.offer(new Penetration(X, Y));
                    visit[X][Y] = true;
                }
            }
        }
    }
}

class Penetration{
    int x, y;

    Penetration(int x, int y){
        this.x = x;
        this.y = y;
    }
}
