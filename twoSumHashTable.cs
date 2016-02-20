public int[] twoSum(int[] nums, int target)
        {
            int[] result = new int[2];

            Dictionary<int,int> set = new Dictionary<int,int>();

            for (int i = 0; i < nums.Length; i++)
            {
                int x = target - nums[i];
                if (set.ContainsKey(x))
                {
                    result[0] = set[x];
                    result[1] = i;
                    return result;
                }
                else
                {
                    set.Add(nums[i], i);
                }
            
            }
            return result;
        
        }
