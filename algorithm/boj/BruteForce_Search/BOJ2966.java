package boj.BruteForce_Search;

//BOJ 2966 찍기

/*
처음에 이 문제를 봤을 때, 해시맵도 생각해보고 무언가 할게 많아 보여서 광범위하게 생각이 났다.
어려운 문제는 아니었는데 할 수 있는 방법들이 많지만, 그중 간단하면서 가독성 좋은 코드가 무엇일까 하는 생각이 어려웠다.
그래서 필요한 것들을 하나씩 하나씩 주석에 정리하면서 문제를 풀게 되었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2966 {
    static char[] sang = {'A','B','C','A','B','C','A','B','C','A','B','C'};
    static char[] chang = {'B','A','B','C','B','A','B','C','B','A','B','C'};
    static char[] hyeon = {'C','C','A','A','B','B','C','C','A','A','B','B'};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken().toUpperCase();

        int index = 0;
        int cntS = 0, cntC = 0, cntH = 0;
        int max = 0;
        for(int i = 0; i < length; i++){
            if(index == 12) index = 0;
            if(str.charAt(i) == sang[index]) cntS++;
            if(str.charAt(i) == chang[index]) cntC++;
            if(str.charAt(i) == hyeon[index]) cntH++;
            index++;
        }
        int []cnt = {cntS,cntC,cntH};

        for(int i = 0; i < cnt.length; i++){
            if(max < cnt[i])
                max = cnt[i];
        }
        System.out.println(max);

        for(int i = 0; i < cnt.length; i++){
            if(max == cnt[i]){
                switch(i){
                    case 0:
                        System.out.println("Adrian");
                        break;
                    case 1:
                        System.out.println("Bruno");
                        break;
                    case 2:
                        System.out.println("Goran");
                        break;
                }
            }
        }
    }
    /*
    1. 규칙성을 보이는 갯수들(3,4,6)의 최소공배수가 12이므로 갯수를 12개로함
    2. 그래서 문자열을 입력받은 뒤에, charAt이용해서 하나하나 비교함.
    3. 각각 cnt를 정해서 같으면 ++해줌.
    4. 이제 그 cnt를 배열에 저장해서 가장 큰 값을 고름
    5. 큰 값과 일치한 index를 뽑아내서 각각 이름을 부여하면 됨 switch 이용
     */
}
