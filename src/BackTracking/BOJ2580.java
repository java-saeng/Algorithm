package BackTracking;

//BOJ 2580 스도쿠

/*
처음에 isConditionTrue를 작성할 때, 행, 열에서 검사하는 것은 쉽게 생각했지만 3*3일 때는 검사를 하기 위해선 총 9개의 범위를 나눠야 하는 생각이 들었다.
하지만 이 9개 범위를 다 나누는 것은 효율적이지 않고, 어떠한 방법이 있을 것이라 생각했다. 그래서 구글링을 하여 힌트를 얻었다.
- 이러한 문제를 풀 때, 규칙성을 찾고 구현하는 실력을 쌓아야겠다.

처음에 backTracking을 돌릴 때, sdk ArrayList에 저장되어 있는 것을 어떻게 꺼내올지가 고민이었다.
이게 무슨 말이냐면, 내가 스도쿠를 입력할 때 숫자가 0 이면 따로 ArrayList에 저장을 했는데, 이 ArrayList 안에 있는 좌표를 어떻게 꺼내올까라는 것이 고민이었다.
반복문을 쓰기에는 스도쿠 숫자 범위가 1~9인데, ArrayList의 size가 꼭 9가 아니라는 점이었다. 그래서 backTracking의 인자로 index를 집어넣어 새로운 그 해당 index의 x, y 좌표를 얻었다.
 */

import java.util.*;
import java.io.*;

public class BOJ2580{
    static int arr[][] = new int[9][9];
    static ArrayList<SdkPoint> sdk = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == 0) sdk.add(new SdkPoint(i, j));
            }
        }

        backTracking(0,0);

    }
    static void backTracking(int index, int count){
        if(count == sdk.size()){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int x = sdk.get(index).x;
        int y = sdk.get(index).y;

        for(int i = 1; i <= 9; i++){
            if(isConditionTrue(x, y, i)){
                arr[x][y] = i;
                backTracking(index + 1, count + 1);
                arr[x][y] = 0;
            }
        }
    }

    static boolean isConditionTrue(int row, int col, int value){

        for(int i = 0; i < 9; i++){
            if(arr[row][i] == value || arr[i][col] == value)
                return false;
        }

        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(arr[i][j] == value)
                    return false;
            }
        }
        return true;
    }

}

class SdkPoint{
    int x, y;
    SdkPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}