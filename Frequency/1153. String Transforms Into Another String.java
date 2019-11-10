class Solution {
    // 这个题长度都一样，
    // map 来统计所有对应的字母对
    // a->c, c->a 这种情况，可以用环以外的字母换，先把 a->d, d->c 
    // return false situation:
    //          1.a->b , a->c 冲突了，不能同时变成不同的字母
    //          2.把所有的26个字母都用完了，才能导致无法转换
    // Time: O(n)
    // Space: O(26)
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char s1 = str1.charAt(i);
            char s2 = str2.charAt(i);
            
            char value = map.getOrDefault(s1, s2);
            if (value != s2) {
                return false;
            }
            map.put(s1, s2);
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }
}
