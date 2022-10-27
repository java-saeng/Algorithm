package boj.bfs_dfs;

//BOJ 7569 토마토

/*
처음에 이 문제를 풀 때 index의 규칙성을 이용하여 이차원 배열로 풀어보려고 시도했다.
입력할 때 만약 1이 입력되면 그 좌표에서 행 크기 만큼 더해주거나 빼주면 될 줄 알았지만, 더하고 빼주는 데에서 문제가 생겼다.
그래서 3차원 배열을 이용하여 풀었다. 3차원 배열을 사용할 때, 높이는 for문의 첫 번째에 시작해주어야 한다. 그 부분에서 실수했다.
그리고 dz [] 배열을 선언하는 데에 있어서 위, 아래를 어떻게 나타내야 하지 라는 생각을 했다. 이번 문제를 통해 그러한 실수와 삼차원을 이용할 때, z를 어떻게 나타낼 수 있는지 알게 되었다.
 */

import java.util.*;

public class BOJ7569 {
    static int row, height, col;
    static Queue<Tomatopoint> q = new ArrayDeque<>();
    static int arr[][][];
    static boolean visit[][][];
    static int result = Integer.MIN_VALUE;
    public static void main(String args[]){
        //3차원으로 풀지 않고 해결할 수 있을 것 같아
        //height만큼 행을 곱해줘서 이차원 배열로 나타내고
        //value가 1인 index는 행렬 범위에 벗어나지 않게
        //열은 똑같고 해당 행 index +- 행 크기 만큼 모두 1로 나타내주기
        //실패 --> 나중에 2차원으로 풀어보자

        //그러면 삼차원 배열로 하기
        Scanner s = new Scanner(System.in);

        col = s.nextInt();
        row = s.nextInt();
        height = s.nextInt();

        arr= new int[row][col][height];
        visit = new boolean[row][col][height];

        //이 부분에서 실수함
        //height 부터 for문을 만들어야함.
        for(int k = 0; k < height; k++){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    arr[i][j][k] = s.nextInt();
                    if(arr[i][j][k] == 1){
                        q.offer(new Tomatopoint(i, j, k ,0));
                    }
                }
            }
        }
        bfs();

        for(int k = 0; k < height; k++){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(arr[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(result);
    }

    static void bfs(){
        int dx[] = {-1,1,0,0,0,0};
        int dy[] = {0,0,1,-1,0,0};
        int dz[] = {0,0,0,0,1,-1}; //z를 캐치 못함
        while(!q.isEmpty()){
            Tomatopoint tp = q.poll();
            int x = tp.x;
            int y = tp.y;
            int z = tp.z;
            int count = tp.count;
            result = boj.Math.max(result, count);
            visit[x][y][z] = true;
            for(int i = 0; i < 6; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];
                int Z = z + dz[i];

                if (!isRangeTrue(X, Y, Z)) continue;
                if (visit[X][Y][Z]) continue;

                if (arr[X][Y][Z] == 0) {
                    arr[X][Y][Z] = 1;
                    q.offer(new Tomatopoint(X, Y, Z, count + 1));
                    visit[X][Y][Z] = true;
                }
            }
        }
    }
    static boolean isRangeTrue(int x, int y, int z){
        return x >= 0 && x < row && y >= 0 && y < col && z >= 0 & z < height;
    }
}

class Tomatopoint{
    int x, y, count, z;

    Tomatopoint(int x, int y, int z, int count){
        this.x  = x;
        this.y  = y;
        this.count = count;
        this.z = z;
    }
}
