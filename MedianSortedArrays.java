package com.itwyz;

import java.util.Scanner;

class MedianSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Result result = getResult(sc);
        System.out.println(findMedianSortedArrays2(result.nums1(), result.nums2()));
    }

    private static Result getResult(Scanner sc) {
        int[] nums1 = new int[sc.nextInt()];
        int[] nums2 = new int[sc.nextInt()];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = sc.nextInt();
        }
        Result result = new Result(nums1, nums2);
        return result;
    }

    private record Result(int[] nums1, int[] nums2) {
    }
//methord 1
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        int[] nums = new int[k];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else return nums2[n / 2];
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else return nums1[m / 2];
        }
        int i = 0, j = 0;
        int count = 0;
        while (count != k) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
            } else if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
            } else {

                if (nums1[i] > nums2[j]) {
                    nums[count++] = nums2[j++];
                } else {
                    nums[count++] = nums1[i++];
                }
            }

        }
        if (k % 2 == 0) {
            return (nums[k / 2 - 1] + nums[k / 2]) / 2.0;
        } else return nums[k / 2];
    }
//methord 2
public static double findMedianSortedArrays2(int[]nums1,int[] nums2){
    int m=nums1.length;
    int n=nums2.length;
    int len =m+n;
    int left=0,right=0;
    int Astart=0,Bstart=0;
    for(int i = 0; i< len /2+1; i++){
        left=right;
        if(Astart<m&&(Bstart>=n||nums1[Astart]<nums2[Bstart])){
            right=nums1[Astart++];
        }
        else{
            right=nums2[Bstart++];
        }
    }
    if((len&1)==0){
        return (right+left)/2.0;
    }
    else{
        return right;
    }
}

}


