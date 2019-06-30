class Solution {
    // Binary Search : give sorted array
    // Same as ’Smallest Element that is larger than target‘
    // when all elements smaller than target, return the first element
    // O (logn)
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                left = mid;
            }else if (letters[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        
        if (letters[left] > target) {
            return letters[left];
        }else if (letters[right] > target) {
            return letters[right];
        }else {
            return letters[0];
        }
    }
}
