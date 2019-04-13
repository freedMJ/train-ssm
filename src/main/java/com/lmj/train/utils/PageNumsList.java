package com.lmj.train.utils;

import java.util.Arrays;

public class PageNumsList {
    //@Value(value = "${common.listNums}")
    private int listNums=5;

    public   int[] nums;



    public  int[] getPageNumArray(int pageNum, int pages){
        //添加一个循环列表
        //int[] nums;
        //分页一次最多listNums页
        //如果总的分页数小于listNums页
        //pages总的分页数
        //当前页
        if(pages<=listNums){
            nums = new int[pages];
            for(int i=0;i<pages;i++){
                nums[i]=i+1;
            }
        }else{
            nums = new int[listNums];
            if(pages-pageNum>=listNums){
                for(int i=0;i<listNums;i++){
                    nums[i]=pageNum+i;
                }
            }else{
                for(int i=0;i<listNums;i++){
                    nums[i]=pages-i;

                }
            }
        }
        Arrays.sort(nums);
        return nums;
    }



}
