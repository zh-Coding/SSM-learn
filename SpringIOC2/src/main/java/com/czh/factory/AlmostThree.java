package com.czh.factory;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhCoding
 * @Description:
 * @create 23:57
 */
public class AlmostThree {

    @Test
    public void test1(){
        int[] arr = new int[]{87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
        System.out.println(threeSumClosest(arr, -275));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums==null||nums.length<3) throw new RuntimeException("输入数组有误！");
        int sum = nums[0] +nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i!=0&&nums[i]==nums[i-1]) continue;
            int j=i+1,k=nums.length-1;
            while (j<k){
                int mid = nums[i]+nums[j]+nums[k];
                if (Math.abs(sum-target)>Math.abs(mid-target)){
                    sum = mid;
                }
                if (mid==target) return target;
                if (mid > target){
                    k--;
                    while ((j+1<k && nums[k+1]==nums[k]))
                        k--;
                }
                if (mid < target){
                    j++;
                    while ((j+1<k && nums[j-1]==nums[j]))
                        j++;
                }
            }
        }
        return sum;

    }
}
