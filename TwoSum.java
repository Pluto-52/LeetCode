package com.itwyz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//method 1：暴力枚举,复杂度为o(n^2)
public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //method 2哈希表,复杂度为o(n)
    public static int[] findTwoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(findTwoSum(nums, target)));//methord 1
        System.out.println(Arrays.toString(findTwoSum2(nums, target)));//methord 2
    }
}
