package bfs_dfs;

//BOJ 4963 섬의 개수

/*
이 문제를 풀면서 dx[], dy[]를 왜 사용하는지 이해를 했다. 원래는 이전 dfs문제들을 풀 때에는, 가로나 세로로 이동하는 문제밖에 없었는데 해당 문제는 대각선까지 사용했다.
그래서 dfs 안에서 돌리기엔 경우의 수가 8가지가 있어 STACKOVERFLOW가 되었다. 그래서 이전부터 가로, 세로로만 이동하는 dfs를 보면 dx[],dy[]를 이용해서 푼 솔루션은 보지 않았다.
왜냐하면 필요가 없을 것이고, 처음에는 이해가 안 되었기 때문이다. 하지만 이 문제를 통해서 다시 왜 그러한 방법을 사용하는지 알게 되었다. 앞으로 dfs 문제를 풀면서 이 방법을 애용할 것 같다.
또, 이 문제를 풀면서 정말 큰 실수를 했다. 이 실수는 두번다시 일어나지 않아야 한다. 처음에 w,h 순으로 입력을 받아서 테스트 케이스 6개 중에 5개는 맞는데 1개만 틀렸다.
그래서 도대체 어느 부분에서 틀렸는지 2시간가량 코드를 살펴보아도 틀린 점이 없어 보였다. 그래서 여쭤보니 w와 h 입력 순서를 바꾸면 해결이 된다는 것이다.
그 말을 듣고 문제를 다시 보니 입력한 값이 반대로 행렬이 만들어지는 것을 발견했다. 더 이상 이런 실수를 저질러선 안된다.
다른 실수가 하나 더 있었다. 이러한 테스트 케이스 개수를 한 번에 반복문에서 사용할 경우, visit배열과 ad배열을 초기화를 다시 시켜주어야 한다는 점이다.
만약 시켜주지 않는다면 데이터가 중첩되어 답이 아닌 경우가 생기기 때문이다. 반복문으로 테케를 돌릴 때에는 항상 초기화를 시켜주는 것을 꼭 명심해야겠다.
 */

import java.util.Scanner;

public class BOJ4963_dfs {
    static int w,h;
    static boolean[][] visit;
    static int[][] ad;
    static int[] dx = {1,1,1,0,0,-1,-1,-1};
    static int[] dy = {0,-1,1,1,-1,1,0,-1};
    static int island;
    public static void main(String []args) {
        Scanner s = new Scanner(System.in);

        //입력 값 받기
        while(true){
            island = 0;
            h = s.nextInt();
            w = s.nextInt();

            if(w == 0 && h == 0 ) break;
            ad = new int[w+1][h+1];
            visit = new boolean[w+1][h+1];
            for(int i = 1; i <= w; i++){
                for(int j = 1; j <= h; j++){
                    ad[i][j] = s.nextInt();
                }
            }
            dfs_start();
            System.out.println(island);
        }
    }

    static void dfs_start(){
        for(int i = 1; i <= w; i++){
            for(int j = 1; j <= h; j++){
                if(!visit[i][j] && ad[i][j] == 1) {
                    dfs(i, j);
                    island++;
                }
            }
        }
    }

    static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i = 0; i < 8; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(row > 0 && row <= w  && col > 0 && col <= h) {
                if (!visit[row][col] && ad[row][col] == 1)
                    dfs(row, col);
            }
        }
    }
}