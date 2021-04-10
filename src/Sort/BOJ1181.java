package Sort;

//BOJ 1181 단어 정렬

/*
이 문제를 읽어보고 오버 라이딩을 하지 않은 sort 메소드를 사용하기엔 부족한 점이 있다고 생각했다.
왜냐하면 문자열의 길이에 따라 먼저 오름차순으로 정렬한 뒤, 길이가 같으면 사전 순으로 정렬하기 때문이다.
그래서 comparator를 사용하여 compare를 오버 라이딩하여 sort 메소드를 재정의하고 정렬하였다.
그리고 중복된 단어가 있을 경우 한 번씩만 출력한다고 했으므로 set을 사용하였고
Set을 다시 ArrayList로 변환시켜서 정렬시켰다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class BOJ1181 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();

        int cnt = Integer.parseInt(st.nextToken());

        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        List<String> arr = new ArrayList<>(set);

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o2.length() == o1.length()){
                    return o1.compareTo(o2);
                }
                else return o1.length() - o2.length();
            }
        };

        Collections.sort(arr, c);

        for(String str : arr)
            System.out.println(str);
    }
}