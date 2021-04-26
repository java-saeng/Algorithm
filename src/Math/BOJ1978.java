package Math;

// BOJ 1978 소수 찾기

import java.io.*;
import java.util.*;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int limit = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int primenum = 0;
        for(int i = 0; i < limit; i++)
            if(findPrime(Integer.parseInt(st.nextToken())) == true) primenum++;

        System.out.print(primenum);

    }
    static boolean findPrime(int num){
        if(num == 1) return false;
        int cnt = 0;
        for(int i = 2; i < num; i++){
            if(num % i == 0) cnt++;
        }
        if(cnt == 0) return true;
        else return false;
    }
}