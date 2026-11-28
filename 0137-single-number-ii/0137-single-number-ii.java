class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int bitind=0;bitind<32;bitind++){
            int count=0;
            for(int i=0;i<nums.length;i++){
                if((nums[i]&(1<<bitind))!=0) count++;
            }
            if(count%3==1){
                ans=ans|(1<<bitind);
            }
        }
        return ans;
    }
}