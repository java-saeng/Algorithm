package Greedy;

// BOJ 1541 잃어버린 괄호

import java.util.*;

public class BOJ1541 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static ArrayList<Integer> al_int = new ArrayList<>();
    static ArrayList<String> al_str = new ArrayList<>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // -를 기준으로 분리시킴
        StringTokenizer st = new StringTokenizer(str, "-");

        //분리시킨 것들 모두 arraylist에 집어넣음
        while(st.hasMoreTokens()){
            al_str.add(st.nextToken());
        }

        //-가 나오기 전까지 앞자리 숫자들임
        //이 숫자들은 괄호를 쳐도 뺄수가 없기 때문에 무조건 더해줘야함

        st = new StringTokenizer(al_str.get(0), "+");

        //그래서 -가 나올 때까지 숫자들을 전부 arrarylist에 넣어줘서 더해줌.
        while(st.hasMoreTokens()){
            al_int.add(atoi(st.nextToken()));
        }

        int sum = 0;
        for(int index : al_int)
            sum += index;

        //예를 들어 50 + 50이면 size가 하나밖에 없기 때문에
        //if 조건을 내세워줌
        if(al_str.size() != 1) {
            for (int i = 1; i < al_str.size(); i++) {
                st = new StringTokenizer(al_str.get(i), "+-");
                while (st.hasMoreTokens()) {
                    sum -= atoi(st.nextToken());
                }
            }
        }
        System.out.print(sum);
    }
}
