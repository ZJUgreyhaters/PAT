class Solution {
    public int lengthOfLastWord(String s) {
        char[] x = s.toCharArray();
        
        int count = 0;
        int flag = 0;
        
        for(int i = s.length() - 1;i >= 0;i--){
            if(x[i] != ' '){
                count++;
                flag = 1;
            }
            else if(x[i] == ' ' && flag == 0){
                
            }
            else if(x[i] == ' ' && flag == 1){
                break;
            } 
        }
        return count;
    }
}