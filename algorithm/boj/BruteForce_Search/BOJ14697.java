package boj.BruteForce_Search;

//BOJ 14697 방 배정하기

/*
생각하는게 어렵지 않은 문제였다.
 */

import java.util.Scanner;

public class BOJ14697 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        int a = 0, b = 0, c = 0, sum = 0;

        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        sum = s.nextInt();

        for(int i = 0; i < 300; i++){
                for(int j = 0; j < 150; j++){
                    for(int k = 0; j < 100; k++){
                        int result = 0;
                        result = ( (a * i) + (b * j) + (c * k) );
                        if(result == sum) {
                            System.out.println(1);
                            return;
                        }
                        if(result > sum)
                            break;
                    }
                }
            }
        System.out.println(0);
        //1. 모든 방 수를 합친게 sum보다 커지면 코드 종료하고 0 출력
        //2. 모든 방 수 작으면 계속해서 코드 진행.
        //3. 모든 방 수 같아지면 종료하고 1 출력
        //4. 여기서 전체 학생수가 300명보다 작거나 같고, 방의 정원이 최소 1,2,3이므로
        //4-1. 범위를 300, 150, 100 이렇게 해도될듯
    }
}
