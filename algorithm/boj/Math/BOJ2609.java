package boj.Math;

//BOJ 2609 최대공약수와 최소공배수

import java.io.*;
import java.util.*;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int max = (num1 >= num2) ? num1 : num2;
        int min = (num1 >= num2) ? num2 : num1;

        int result1 = gcd(max,min);
        int result2 = max * min / result1;

        sb.append(result1 + "\n" + result2);
        System.out.print(sb);
    }
    static int gcd(int max, int min){
        while(min != 0){
            int temp = max % min;
            max = min;
            min = temp;
        }
        return max;
    }
}