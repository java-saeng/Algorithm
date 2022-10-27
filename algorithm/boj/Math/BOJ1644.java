package boj.Math;

//BOJ 1644 소수의 연속합

/*
처음에 이 문제를 풀 때, 투 포인터라는 개념을 몰랐다. 그래서 에라토스테네스의 체를 이용하여 visit배열에 소수인 부분을 true로 하고, ArrayList에 소수인 index만 넣었다.
그리고 이중 포문을 이용했지만, n이 4,000,000이어서 당연하게 TLE가 날 것이라 생각하고 제출을 했다. 당연하게 TLE가 났다. 그래서 구글링 하여 힌트를 얻었고, 투 포인터라는 개념을 새로 알게 되었다.
다음번에 투 포인터에 대해 자세히 다뤄볼 것이다.
 */

import java.io.*;
import java.util.*;

public class BOJ1644{
    static boolean visit[];
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.parseInt(st.nextToken());
        visit = new boolean[max+1];
        Arrays.fill(visit, true);
        for(int i = 2; i < visit.length; i++){
            if(visit[i]){
                for(int j = i * 2; j < visit.length; j += i){
                    visit[j] = false;
                }
            }
        }

        for(int i = 2; i < visit.length; i++){
            if(visit[i]) al.add(i);
        }
        howManyPrime(max);

    }
    static void howManyPrime(int num){
        int cnt = 0, sum = 0, st = 0, ed = 0;
        while(true){
            if(sum >= num) sum -= al.get(st++);
            else if(ed == al.size()) break;
            else sum += al.get(ed++);
            if(sum == num) cnt++;
        }
        System.out.print(cnt);
    }
}

