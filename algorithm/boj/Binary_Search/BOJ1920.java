package boj.Binary_Search;

//BOJ 1920 수 찾기

/*
이 문제는 이분탐색의 가장 기본적인 문제라고 할 수 있다.
search 메소드에 주석처리 부분은 if문을 사용하여, 재귀함수 형태로 나타낸 것이고, 아래는 while문을 통한 반복문을 통해 나타낸 것이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class  BOJ1920{
    static int [] arr1; //있는지 확인하는 배열
    static int [] arr2; //찾아야할 번호들
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr1 = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());

        arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr1);

        for(int i = 0; i < arr2.length; i++){
            System.out.println(search(0,arr1.length-1,arr2[i]));
        }
    }
    //1. 숫자가 mid index의 값보다 작으면 왼쪽 다시 탐색
//2. 크면 오른쪽 다시 탐색.
    public static int search(int start, int end, int find){
        /*if(start > end) return 0;

        int mid;
        mid = (start+end) / 2;

        if(arr1[mid] == find)
            return 1;
        else if(arr1[mid] > find)
            return search(start,mid-1,find);
        else
            return search(mid+1,end,find);*/

        while(start <= end){
            int mid = (start+end) / 2;
            if(arr1[mid] == find)
                return 1;
            else if(arr1[mid] > find)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return 0;
    }
}