package boj.Dynamic_Programming;

//BOJ 1932 정수 삼각형

/*
 https://c-king.tistory.com/233
 */

import java.io.*;
import java.util.*;

class BOJ1932{
    static int size;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         size = Integer.parseInt(st.nextToken());

         int triangle[][] = new int[size][size];
         int count[][] = new int[size][size];

         for(int i = 0; i < size; i++){
             st = new StringTokenizer(br.readLine());
             for(int j = 0; j < i+1; j++){
                 triangle[i][j] = Integer.parseInt(st.nextToken());
             }
         }

         count[0][0] = triangle[0][0];
         int max = Integer.MIN_VALUE;
         for(int i = 1; i < size; i++){
             for(int j = 0; j <= i; j++){
                 if(j == 0) count[i][j] = count[i-1][j] + triangle[i][j];
                 else if(i == j) count[i][j] = count[i-1][j-1] + triangle[i][j];
                 else{
                     count[i][j] = boj.Math.max(count[i-1][j-1] + triangle[i][j], count[i-1][j] + triangle[i][j]);
                 }
                 max = boj.Math.max(max, count[i][j]);
             }
         }
         System.out.print(max);
    }
}