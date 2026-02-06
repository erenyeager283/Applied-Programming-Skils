class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        // 1️⃣ Count character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // 2️⃣ Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
