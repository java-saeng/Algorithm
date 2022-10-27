package boj.BruteForce_Search;

//BOJ 3040 백설 공주와 일곱 난쟁이

/*
9개의 수 중에 합이 100이 되는 7개의 숫자를 찾는 문제였다. 여기서 7개의 숫자를 찾기 위해, 7개의 포문을 돌릴 수 없기 때문에 어떤 방법을 사용해야 할지 생각을 해보았다.
그래서 sum에 모든 배열의 합을 넣은 뒤에, 9개의 숫자 중에 2개의 숫자만 빼면 되기 때문에, 이중 포문을 이용하여 sum에서 두 숫자를 빼면 100이 나오는 두 숫자를 찾으면 된다.
그래서 nonum1, nonum2에 저장하여 배열 전체를 탐색하여 nonum1, nonum2의 index값을 갖지 않는 배열 값을 구하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3040 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ad[] = new int[9];
        int nonum1 = 0, nonum2 = 0;
        int sum = 0;
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            ad[i] = Integer.parseInt(st.nextToken());
            sum += ad[i];
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sum - ad[i] - ad[j] == 100){
                    nonum1 = i;
                    nonum2 = j;
                }
            }
        }
        for(int i = 0; i < 9; i++){
            if(i != nonum1 && i != nonum2)
                System.out.println(ad[i]);
        }
    }
}
