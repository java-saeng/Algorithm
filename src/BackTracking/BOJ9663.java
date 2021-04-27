package BackTracking;

import java.io.*;
import java.util.*;

public class BOJ9663 {
    static int arr[];
    static int size;
    static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        arr = new int[size];

        backTracking(0);

        System.out.println(count);
    }

    static boolean isRangeTrue(int row){
        //3
        boolean flag = true;

        for(int i = 0; i < row; i++){
            if(arr[row] == arr[i] || Math.abs(row-i) == Math.abs(arr[row] - arr[i]))
                flag = false;
            //같은 열에 있거나 대각선에 있을 때 false
        }
        return flag;
    }

    static void backTracking(int depth){
        //1
        if(depth == size){
            count++;
            return;
        }

        for(int i = 0; i < size; i++){
            //2
            arr[depth] = i;
            if(isRangeTrue(depth)){ //이 부분이 백트래킹과 dfs의 차이를 나타냄.
                backTracking(depth + 1);
            }
        }
    }
}
