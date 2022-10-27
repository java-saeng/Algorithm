package boj.Greedy;

//BOJ 1758 알바생 강호

import java.io.*;
import java.util.*;

public class BOJ1758 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static Integer[] arr;
    //내림차순을 사용하기 위해 Wrapper 클래스로 선언
    //Comparator를 쓰기 위해서는 객체 형태이어야함. 그래서 처음에
    //int형으로 선언하고 왜 Comparator가 안쓰이지라는 생각을 했는데
    //객체로 선언안해서 그랬음. 기본 자료형은 Comparator를 호출할 수 없음.

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = atoi(st.nextToken());
        arr = new Integer[size];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = atoi(st.nextToken());
        }

        //내림차순 정렬
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(sumTip());
    }
    static long sumTip(){
        //여기서 왜 맞왜틀이 나옴.
        //보니까 N이 100,000보다 작은 자연수인데 팁도 100,000보다 작거나 같은 자연수임
        //그래서 100,000 * 100,000 해보면 21억이 넘어서 int형으로 하면 틀림.
        //이것 때문에 시간 오래 걸림. 항상 생각하자.
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            int tip = arr[i] - i;
            if(tip >= 0) sum += tip;;
        }
        return sum;
    }
}


