package boj.Binary_Search;

//BOJ 2776 암기왕

/*
처음에 이 문제를 풀 때 중복이 되는지 안되는지 확인을 하지 않고 일반적인 이분탐색 문제라고 생각을 하고 풀었지만 당연하게 바로 틀렸다.
그래서 왜 틀렸나 보니, 내가 풀었던 문제들(ex 숫자 찾기)는 중복되지 않는다고 미리 전제로 깔아놓았지만 이 문제는 중복 얘기를 하지 않았다.
그래서 중복이 나올 수 있다는 가정을 생각하고 처음에는 Set 컬렉션에 데이터를 집어넣은 뒤, Set 컬렉션을 Array로 바꾸어서 문제를 풀면 되겠다고 생각했다.
하지만 제출을 하고 난 뒤, 런타임 에러가 떴고, 왜 떴는지 자세히 보니 문제에서 int형을 다룬다고 쓰여있다고 했다. 그러면 set을 쓰지 말라는 건가?라고 생각이 들었다.
그러면 어떻게 중복되는 데이터를 빼낼 수 있을까라는 생각을 하였다. 거기서 HashMap이 생각이 났다.
HashMap에 원래의 데이터를 넣고, 데이터가 존재하지 않을 경우에 데이터를 넣는다.
그리고 binarySearch 메소드에서 이 숫자가 있는지 없는지 판별하기 위해서, noteMap에 key로 num이 있는지 없는지 확인만 하면 중복을 빼낼 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2776 {
    static int note[];
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> noteMap;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());
        int n,m;


        for(int i = 0; i < test; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            note = new int[n];
            noteMap = new HashMap<>();

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                note[j] = num;
                if(!noteMap.containsKey(num))
                    noteMap.put(num,1);
            }

            Arrays.sort(note);

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                binarySearch(num);
            }
        }

        System.out.print(sb);
    }
    //1. noteSet에 수첩 1의 데이터를 저장
    //2. 그다음에 noteSet을 배열로 만들고 정렬하기
    //3. 수첩2의 데이터를 binarySearch 메소드에 한개씩 넣기
    //4. sb에 1 또는 0을 넣기
    //--------------------------------------------문제에서 int범위로 사용하기 때문에 set을 array로 바꾸지못함
    //--------------------------------------------왜냐하면 set을 배열로 바꾸려고 하면 array 자료형이 Integer가 되어야함
    //1. note 배열에 수첩1 데이터 저장
    //2. noteMap에 note배열들의 자료들을 저장 --> 왜냐하면 중복이 있을 수 있으므로
    //3. note 데이터를 정렬하고 binarySearch에 수첩2 데이터를 넣기
    //3-1. binarySearch에는 인자로 들어있는 num이 noteMap에 포함되어있는 key라면 그 때 1을 반환하게 하면 됨.
    public static void binarySearch(int num){
        int st,ed,mid;
        st = 0;
        ed = note.length-1;
        while(st <= ed){
            mid = (st + ed) / 2;
            if(noteMap.containsKey(num)){
                sb.append(1 + "\n");
                return;
            }
            else if(note[mid] > num) ed = mid - 1;
            else st = mid + 1;
        }
        sb.append(0 + "\n");
    }
}
