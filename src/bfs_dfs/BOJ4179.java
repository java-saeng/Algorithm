package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static char[][] A;
    static Queue<Integer> startQ = new ArrayDeque<>();
    static Queue<Integer> fireQ = new ArrayDeque<>();
    static boolean startV[][];
    static boolean fireV[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        int time = 1;
        int flag = 0;
        while (true) {
            bfsFire();
            flag = bfsMove();
            if(flag == -2 || flag == 1) break;
            else time++;
        }

        if(flag == -2) System.out.println("IMPOSSIBLE");
        else System.out.println(time);
    }

    static int bfsMove() {
        int size = startQ.size();

        if(size == 0) return -2; //지훈이가 갈 데가 없어서 -> IMPOSSIBLE

        for (int i = 0; i < size / 2; i++) {
            int x = startQ.poll();
            int y = startQ.poll();

            if(x == row-1 || y == col-1 || x == 0 || y == 0){
                return 1; //도착할 경우
            }

            for (int j = 0; j < 4; j++) {
                int dX = x + dx[j];
                int dY = y + dy[j];

                if(!isRangeTrue(dX,dY)) continue;
                if(startV[dX][dY]) continue;
                if(A[dX][dY] == '#' || A[dX][dY] == 'F') continue;

                startQ.offer(dX);
                startQ.offer(dY);
                startV[dX][dY] = true;
            }
        }
        return -1; //이 경우는 이번 턴에는 도착하지 못해서
    }

    static void bfsFire() {
        int size = fireQ.size();

        if(size == 0) return;

        for (int j = 0; j < size / 2; j++) {
            int x = fireQ.poll();
            int y = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int dX = x + dx[i];
                int dY = y + dy[i];

                if(!isRangeTrue(dX,dY)) continue;
                if(fireV[dX][dY]) continue;
                if(A[dX][dY] == '#') continue;

                fireQ.offer(dX);
                fireQ.offer(dY);
                fireV[dX][dY] = true;
                A[dX][dY] = 'F';
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }



    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        startV = new boolean[row][col];
        fireV = new boolean[row][col];

        A = new char[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                A[i][j] = str.charAt(j);
                if(A[i][j] == 'J'){
                    startQ.offer(i);
                    startQ.offer(j);
                    startV[i][j] = true;
                }
                if(A[i][j] == 'F'){
                    fireQ.offer(i);
                    fireQ.offer(j);
                    fireV[i][j] = true;
                }
            }
        }
    }
}
