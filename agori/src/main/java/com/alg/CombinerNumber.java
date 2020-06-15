package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/14
 */
public class CombinerNumber {


    public static void main(String[] args) {
        CombinerNumber combinerNumber = new CombinerNumber();
        List<List<Integer>> res = combinerNumber.combine(4,2);
        System.out.println("res = " + res);
    }


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList();
        backtrack(n,k,1,new ArrayList(),ans);
        return ans;
    }



    public void backtrack(int n,int k,int start,List<Integer> temp,List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int i =start;i<=n;i++){
            temp.add(i);
            backtrack(n,k-1,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }


    }
    

}
