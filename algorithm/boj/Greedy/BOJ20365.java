package boj.Greedy;

import java.util.*;

public class BOJ20365 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> bstr = new ArrayList<>();
        ArrayList<String> rstr = new ArrayList<>();
        int result = 0;
        int size = sc.nextInt();
        String str = sc.next();

        //R를 구분자로 파싱
        StringTokenizer st = new StringTokenizer(str, "R");

        while(st.hasMoreTokens()){
            bstr.add(st.nextToken());
        }

        //B를 구분자로 파싱
        st = new StringTokenizer(str, "B");

        while(st.hasMoreTokens()){
            rstr.add(st.nextToken());
        }

        //R이 더 많으면 R을 한번에 깔고 B의 집단?를 놓으면 됨
        //1을 더해주는 이유는 한 번에 깔 때 횟수를 의미
        if(rstr.size() >= bstr.size()){
            result = 1 + bstr.size();
        }
        //else도 마찬가지고 B가 더 많으면 B를 한번에 깔고 R의 집단을 놓으면 됨
        else{
            result = 1 + rstr.size();
        }

        System.out.print(result);
    }
}
