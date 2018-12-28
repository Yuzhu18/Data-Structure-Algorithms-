    // assump : sorted / unsorted
    //          duplication or not 
    //          all rst or only one
    
    //利用 two - sum 
    //此题有duplicate
    // time: O(n^2) || sort nlogn two loop n^2
    // space: O(n) || sort

    public List<List<Integer>> threeSum(int[] nums) {     
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i ++) {  
            //remove duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1; 
            int right = nums.length - 1;
        
            while (right > left) {
                if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {                                        
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // remove duplicate 
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }
