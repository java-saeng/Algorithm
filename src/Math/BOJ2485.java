package Math;

//BOJ 2485 가로수

/*
처음에 이 문제를 접근할 때, 조건 2개를 계속 생각했다.
1. 가로수를 같은 간격에 심기
2. 심어야 하는 가로수의 개수가 최소
그래서 갯수가 최소가 되기 위해서는 간격이 최대가 돼야 하며,
그 간격이 이미 심어져 있는 가로수와 일치해야 한다.
그래서 문제를 풀 때 배열로 입력받고, 그 간격들을 배열에 저장하였다.
그리고 그 간격들의 최대공약수를 구했고, 그 최대공약수를 간격으로 정했다.
 */

import java.util.*;
import java.io.*;

public class BOJ2485{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeSize = Integer.parseInt(st.nextToken());
        int tree[] = new int[treeSize];

        for(int i = 0; i < treeSize; i++){
            st = new StringTokenizer(br.readLine());
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int interval[] = new int[treeSize-1];

        for(int i = 0; i < interval.length; i++){
            interval[i] = Math.abs(tree[i] - tree[i+1]);
        }

        int real_inter = interval[0];

        for(int i = 1; i < interval.length; i++){
            real_inter = GCD(real_inter, interval[i]);
        }

        int result = -treeSize;

        for(int i = tree[0]; i <= tree[treeSize-1]; i += real_inter){
            result++;
        }

        System.out.print(result);
    }

    static int GCD(int num1, int num2){
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        while(min != 0){
            int temp = max % min;
            max = min;
            min = temp;
        }

        return max;
    }
}
