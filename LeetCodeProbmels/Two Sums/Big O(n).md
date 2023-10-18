
#leetCode #code #learning #Java 

class Solution {

    public int[] twoSum(int[] nums, int target) {

       Map<Integer, Integer> numMap = new HashMap<>();

       int n = nums.length;

       for(int i = 0; i < n; i++){

           numMap.put(nums[i], i);

       }

       for(int i = 0; i < n; i++ ){

           int complement = target - nums[i];

           if(numMap.containsKey(complement) && numMap.get(complement) !=i){

               return new int[]{numMap.get(complement), i};

           }

       }

       return new int[]{};

    }

}