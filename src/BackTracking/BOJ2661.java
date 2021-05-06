package BackTracking;

//BOJ 2661 좋은 수열

/*
문제를 처음 볼 때, StringBuilder를 사용해서 isConditionTrue를 만족하면 sb에 넣고, 틀리면 sb에 있는 제일 끝에 있는 문자를 지우려고 했다.
하지만 sb는 전역 변수로 사용해서 조건식에 넣을 때마다 무조건 문자를 넣게 되고, 삭제를 해도 그 문자 그대로였다.
그래서 코드를 싹 다 갈아엎고, 처음부터 시작했다. int형으로 선언할지, String으로 선언할지 고민하다가 문제에서 N이 80 이하라고 하여, int형으로는 80자리를 받을 수 없어 String을 이용하기로 했다.
그리고 백트래킹을 무조건 하나를 추가하고 검사하고 다시 하나를 삭제한다. 이런 생각은 안 갖는 게 이 문제를 통해 알게 되었다.
나는 백트래킹이 무조건 하나를 추가하고 다음으로 넘어가서 그게 아니면 다시 지우고 이렇게 생각해서 꼭 문자를 추가했다가, 다음으로 넘어가서 아니면 삭제해야 한다 이렇게 문제를 풀어 난관에 부딪히게 됐다.
이 문제는 조건에 맞는 걸 먼저 찾는 다음에 추가해주었다.

새로 알게 된 점은 return과 System.exit(0)의 차이이다. return은 그 해당 메소드를 끝내는 것이고, 즉, stack에 아직 함수들이 남아있다면 계속해서 실행하고, System.exit(0)은 프로그램 자체를 종료시키는 것이다.
이 문제는 최솟값을 구하는 것이기 때문에 숫자가 나오면 바로 System.exit(0)을 해주어야 한다. 만약 return을 하게 된다면 전에 stack에 남아있던 함수들이 모조리 실행되어 오답을 형성한다.
그래서 아래에서 보이는 코드는 return을 사용했을 때이다. 만약 System.exit(0)을 사용한다면 주석 부분만 사용하면 된다.
 */

import java.io.*;
import java.util.*;

public class BOJ2661 {
    static int length;
    static char[] arr = {'1', '2', '3'};
    static boolean flag;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());

        backTracking("");
    }

    static void backTracking(String str) {
        if(flag) return;

        if (str.length() == length ) {
            flag = true;
            System.out.print(str);
        }

        /*if(str.length() == length){
            System.out.print(str);
            System.exit(0);
            //return;
        }*/

        for (int i = 0; i < arr.length; i++) {
            if (isConditionTrue(str + arr[i])) {
                backTracking(str + arr[i]);
            }
        }


    }

    static boolean isConditionTrue(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            if (str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i)))
                return false;
        }
        return true;
    }
}