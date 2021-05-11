package Dynamic_Programming;

//BOJ 1463 1로 만들기

import java.io.*;
import java.util.*;

public class BOJ1463 {
    static int count[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        count = new int[num+1];

        for(int i = 2; i <= num ; i++){
            count[i] = count[i-1] + 1;
            if(i%3 == 0)
                count[i] = Math.min(count[i/3] + 1, count[i]);
            if(i%2 == 0)
                count[i] = Math.min(count[i/2] + 1, count[i]);
        }

        System.out.println(count[num]);
    }
}
