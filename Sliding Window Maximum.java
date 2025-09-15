// Problem Link : https://leetcode.com/problems/sliding-window-maximum/description/

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deq = new LinkedList<>();

        int i = 0;

        int ind = 0;

        while(i < n) {

            while(!deq.isEmpty() && deq.getFirst() <= (i - k)) deq.removeFirst();

            while(!deq.isEmpty() && nums[deq.getLast()] < nums[i]) deq.removeLast();

            deq.addLast(i);

            if(i >= (k - 1)) result[ind++] = nums[deq.getFirst()];

            i++;
        }

        return result;
        
    }
}
