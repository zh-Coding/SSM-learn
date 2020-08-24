package com.czh.dao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 0:58
 */
public class ThreeSum {
    @Test
    public void test2(){
        int[] arr = new int[]{1,-1,-1,0};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
        lists.forEach(System.out::println);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if(nums==null||nums.length<3) return list;
        Arrays.sort(nums);
        if(nums[nums.length-1]<0) return list;
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            twoSum(i,nums,list);
            }

        return list;
    }
    public void twoSum(int n,int[] nums,List<List<Integer>> list){
        int i=n+1,j=nums.length-1,target=(-nums[n]);

        while(i<j){
            long sum = (long)nums[i]+(long)nums[j];
            if(sum==target) {
                list.add(Arrays.asList(nums[n],nums[i],nums[j]));
                // 2层去重，111333这种情况，只需要算一次，i,j 移动到 最内部 1，3
                while (i + 1 < j && nums[i+1] == nums[i]) i++;
                while (j - 1 > i && nums[j-1] == nums[j]) j--;
            }
            if (sum>target){
                j--;
            }else i++;
        }
    }
    @Test
    public void test1(){
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.forEach(System.out::println);
    }
}
