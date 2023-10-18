#leetCode #code #learning #Java 

class Solution {

    public int[] twoSum(int[] nums, int target) {

       for(int i = 0; i < nums.length -1; i++){
	       for(int j = 0 + 1; j < nums.length; j++ ){
		       if( nums[i] + nums[j] == target ){
					return new int[]{};
			    }
	       }
       }
       return new int[]();

    }

}