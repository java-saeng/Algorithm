package BruteForce_Search;

//BOJ 14916 거스름돈

import java.util.*;

public class BOJ14916 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int coin = s.nextInt();
        int cnt = 0;
        int chance = coin / 5;
        boolean flag = false;

        for (int i = chance; i >= 0; i--) {
            int num = coin;
            num -= 5 * i;
            while(true) {
                if (num % 2 != 0) break;
                else {
                    cnt = num / 2;
                    cnt += i;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        if (cnt == 0)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }
}
