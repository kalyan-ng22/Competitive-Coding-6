// Time Complexity : O(n!) as we are computing permutations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We need to generate permutations by always looping from index 1 and mark the already present ones in the boolean used array.
// As duplicates are not allowed in permutations, we check used array and add to the path. When we reach end of path, we check the
// index divisibility condition with value and increment the result count and continue the for loop recursion.

class Solution {
    int result;
    boolean[] used;

    public int countArrangement(int n) {
        this.result = 0;
        this.used = new boolean[n + 1];
        helper(n, 1, new int[n+1]);
        return result;
    }

    private void helper(int n, int pivot, int[] path) {
        if (pivot > n) {
            for (int i = 1; i <= n; i++) {
                if (!(i % path[i] == 0 || path[i] % i == 0)) { //divisibility condition check
                    return;
                }
            }
            result++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) { //if not already present in path
                path[pivot] = i; //action
                used[i] = true;
                helper(n, pivot + 1, path); //recurse
                used[i] = false; //backtrack
            }
        }
    }
}