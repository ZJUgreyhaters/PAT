class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 1;
        int re = 0;
        test:
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == nums[i+1]){
                count++;
                if(count> nums.length/2){
                   re = nums[i];
                    break test;
                }
                  
            }
            else{
                count = 1;
                if(count> nums.length/2){
                    re = nums[i];
                    break test;
                }
            }
        }
        return re;
    }
}