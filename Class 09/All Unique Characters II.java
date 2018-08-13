public class Solution {
    public boolean allUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        int[] bit_vector = new int[8];

        for (int i = 0; i < word.length(); i++) {
            int row = word.charAt(i) / 32;
            int col = word.charAt(i) % 32;
            int weight = 1 << col;
            if ((bit_vector[row] & weight) != 0) {
                return false;
            }
            bit_vector[row] |= weight;
        }
        return true;
    }
}
