class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] window = new int[26];

        // Build frequency for s1
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(freq1, window)) {
            return true;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new character to window
            window[s2.charAt(i) - 'a']++;

            // Remove leftmost character
            window[s2.charAt(i - s1.length()) - 'a']--;

            if (matches(freq1, window)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}