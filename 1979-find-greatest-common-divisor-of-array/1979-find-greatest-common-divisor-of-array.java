class Solution {
    public int findGCD(int[] nums) {
        int first=Integer.MIN_VALUE;
        int second=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            first=Math.max(first,nums[i]);
            second=Math.min(second,nums[i]);
        }
        return gcd(second,first);
    }
    public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}