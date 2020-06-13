"""
Python3 Implementation
Time Complexity : O(log(N))
Space Complexity : O(1)
Run on leetcode : YES
"""



class Solution:

    # pivot method easy 

    def findMin_using_pivot(self, nums: List[int]) -> int:
        
        if not nums or len(nums) == 0:
            return -1
        
        left = 0 
        right = len(nums) - 1
            
        while left < right :
#             if already sorted
            
            mid = int( ( left + right) / 2 )
            # /min element is the element which is less than both of adjacent element
            
    

    def findMin(self, nums: List[int]) -> int:
        
        if not nums or len(nums) == 0:
            return -1
        
        left = 0 
        right = len(nums) - 1
        if nums[left] < nums[right]:
            return nums[left]
            
        while left <= right :
#             if already sorted
            
            mid = int( ( left + right) / 2 )
            # /min element is the element which is less than both of adjacent element
            if mid > 0 and nums[mid-1] < nums[mid]:
                right = mid
            else:
                left = mid + 1
        return nums[left]
            

                
                