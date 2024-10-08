package com.itwyz;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m > n) {
           int temp = n;
           n = m;
           m = temp;
        }
        int count = 0;
        for (int i = m; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i + "是质数");
                count++;
            }
        }
        System.out.println(m + "和" + n + "之间有" + count + "个质数");
    }
}
