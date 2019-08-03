class Solution {
    
    //O(logn)
    public int search(ArrayReader reader, int target) {
        int right = 1;
        while (reader.get(right) != 2147483647) {
            right = right * 2;
        }
        return binarySearch(reader, target, right);
    }
    
    private int binarySearch(ArrayReader reader, int target, int right){
        int left = 0;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == 2147483647 || reader.get(mid) > target) {
                right = mid;
            }else if (reader.get(mid) == target) {
                return mid;
            }else {
                left = mid;
            }
        }
        if (reader.get(left) != 2147483647 && reader.get(left) == target) {
            return left;
        }else if (reader.get(right) != 2147483647 && reader.get(right) == target) {
            return right;
        }else {
            return -1;
        }
    }
}
