package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col, T;
    static int A[][]; //원래 입력된 배열
    static int real[][];  //바뀌는 배열
    static Queue<Integer> q; //미세먼지
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, - 1};
    static int air[];
    static int rotate[][];
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {

        while(T-- > 0) {
            setQueue();
            real = new int[row][col];
            spreadDust();
            rotate();
        }

        int sum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(A[i][j] == -1) continue;
                sum += A[i][j];
            }
        }

        System.out.println(sum);
    }

    static void spreadDust() {
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if(!isRangeTrue(X,Y)) continue;
                if(A[X][Y] == -1) continue;

                real[X][Y] += A[x][y] / 5;
                cnt++;
            }
            real[x][y] = real[x][y] + (A[x][y] - (A[x][y] / 5) * cnt);
        }
    }

    static void setQueue() {
        q = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(A[i][j] > 0){
                    q.offer(i);
                    q.offer(j);
                }
            }
        }
    }

    static void rotate() {
        rotate = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotate[i][j] = real[i][j];
            }
        }
        //---> 방향
        for (int i = 1; i < col; i++) {
            rotate[air[0]][i] = real[air[0]][i - 1];
            rotate[air[1]][i] = real[air[1]][i - 1];
        }

        // <---- 방향
        for (int i = col - 1; i >= 1; i--) {
            rotate[0][i - 1] = real[0][i];
            rotate[row - 1][i - 1] = real[row - 1][i];
        }

        //아래 방향
        for (int i = 0; i < row - 1; i++) {
            if (i >= air[1]) {
                rotate[i + 1][col - 1] = real[i][col - 1];
            } else {
                rotate[i + 1][0] = real[i][0];
                if (i + 1 == air[0]) rotate[i + 1][0] = 0;
            }
        }

        //공기청정기 윗부분 위 방향
        for (int i = air[0]; i >= 1; i--) {
            rotate[i - 1][col - 1] = real[i][col - 1];
        }

        //공기청정기 아랫부분 위방향으로
        for (int i = row - 1; i > air[1]; i--) {
            rotate[i - 1][0] = real[i][0];
            if (i - 1 == air[1]) rotate[i - 1][0] = 0;
        }

        //공기청정기 위치 나타내기 --> spread할 때 필요함
        rotate[air[0]][0] = -1;
        rotate[air[1]][0] = -1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                A[i][j] = rotate[i][j];
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
        T = atoi(st.nextToken());

        A = new int[row][col];
        air = new int[row];
        int idx = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                A[i][j] = atoi(st.nextToken());
                if(A[i][j] == -1){
                    air[idx] = i;
                    idx++;
                }
            }
        }
    }
}
