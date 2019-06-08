class Solution {
    
    // time: one pass O(n)
    // space: map  O(1)
    public int romanToInt(String s) {
        int rst = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
            
        int last = map.get(s.charAt(0));
        rst += last;
        for(int i = 1; i < s.length(); i++){
            int cur = map.get(s.charAt(i));
            // last character >= cur character , we should add together
            if(last >= cur){
                rst += cur;
            }else{
                // "IV" -> 4, we should minus
                rst = rst  + cur - last -last; 
            }
            last = cur;
        }
        return rst;
    }
}
