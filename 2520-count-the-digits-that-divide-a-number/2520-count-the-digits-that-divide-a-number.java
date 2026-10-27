class Solution {
    public int countDigits(int num) {
        int original = num;
        int count = 0;
        while(original!=0){
            int rem = original%10;
            if(num%rem==0){
                count+=1;
            }
            original=original/10;
        }
        return count;
    }
}