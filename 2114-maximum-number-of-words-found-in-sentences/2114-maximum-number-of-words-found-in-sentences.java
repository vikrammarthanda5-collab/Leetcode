class Solution {
    public int mostWordsFound(String[] sentences) {
        int count=0;
        for(String curr : sentences){
            int curlen=curr.split(" ").length;
            if(count<curlen){
                count=curlen;
            }
        }
        return count;
    }
}