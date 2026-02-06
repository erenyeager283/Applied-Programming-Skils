class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;

        // Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }

        // Fill remaining positions with 0
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}
