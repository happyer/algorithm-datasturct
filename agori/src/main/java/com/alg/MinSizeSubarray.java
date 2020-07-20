package com.alg;

/**
 * Created by chengxu03 on 2020/7/19.
 */
public class MinSizeSubarray {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        MinSizeSubarray minSizeSubarray = new MinSizeSubarray();
        System.out.println(minSizeSubarray.minSubArrayLen3(11, arr));

    }


    public int binarySearch(int target, int beg, int end, int[] nums){
        //find the index of first element that is bigger than or equals target
        int left = beg;
        int right = end;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target) right = mid;
            else left = mid +1 ;
        }
        if(right==nums.length-1&&nums[right]<target) return -1;
        return right;

    }
    public int minSubArrayLen3(int s, int[] nums) {
            int n = nums.length;
            if(n==0) return 0;
            int res = Integer.MAX_VALUE;
            int[] sum = new int[n+1];
            sum[0] = 0;
            for(int i = 1; i<=n; i++) sum[i] = sum[i-1] + nums[i-1];
            for(int i = 0; i<n; i++){
                int target = s + sum[i];
                int border = binarySearch(target,0,n,sum);
                if(border>0) {
                    res = Math.min(res,border-i);
                    System.out.printf("bor=%d\n",border);
                }
            }
            return (res!=Integer.MAX_VALUE?res:0);
    }


    public int minSuArrayLen2(int s, int[] nums) {


        int ans = Integer.MAX_VALUE;

        int sums[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            int target = s + sums[i];
            int index = binarySearch(sums, target, i, sums.length);
            if (index != -1) {
                ans = Math.min(ans, index - i);
                System.out.printf("index=%d,base=%d\n", index, i);
            }
        }

        return ans;
    }


    public int binarySearch(int[] src, int target, int start, int end) {

        while (start < end) {

            int mid = start + (end - start) / 2;
            int t = src[mid];
            if (t == target) {
                System.out.printf("start=%d,mid=%d,end=%d,target=%d \n",start,mid,end,target);
                return mid;
            }
            if (t > target) {
                end = mid;
            } else {
                start = mid+1;
            }

        }
        return -1;

    }

    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int start = 0;
        int end = 0;
        while (start < n && end < n) {
            int t = getSum(nums, start, end);
            if (s == t) {
                ans = Math.min(ans, (end - start - 1));
                start++;
                end = start;
            } else if (s > t) {
                end++;
            } else {
                start++;
                end = start;
            }
        }

        return ans;

    }


    public int getSum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }


}
