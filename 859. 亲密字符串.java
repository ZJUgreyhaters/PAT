class Solution {
    public boolean buddyStrings(String A, String B) {
        if((A.length() < 2) || (A.length() != B.length()))
            return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        
        int index_l = -1;
        int index_r = -1;
        int flag = 0;
        
        for(int i = 0;i < A.length();i++){
            if((flag == 0) && (a[i] != b[i])){
                index_l = i;
                flag = 1;
            }
            else if((flag == 1) && (a[i] != b[i])){
                index_r = i;
                flag = 2;
            }
            else if((flag == 2) && (a[i] != b[i])){
                return false;
            }
        }
        
        if(index_l != -1 && index_r == -1){
            return false;
        }
        else if(index_l == -1 && index_r == -1){
            for(int i = 0;i < A.length() - 1;i++){
                for(int j = i + 1;j < A.length();j++){
                    if(a[i] == a[j])
                        return true;
                }
            }
            return false;
        }

        if((a[index_l] == b[index_r]) && (a[index_r] == b[index_l])){
            return true;
        }
        else return false;
    }
}