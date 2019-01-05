class Solution {
    //1. BFS ,利用queue
    //time: O(3^n / 4^n)
    //space: recursion O(3^n)
    public List<String> letterCombinations(String digits) {
        LinkedList<String> rst = new LinkedList<String>();
        if(digits.length() == 0){
            return rst;
        }
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno","pqrs","tuv", "wxyz"};
        rst.add("");
        for(int i = 0; i < digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i));
            while(rst.peek().length() == i){
                String last = rst.remove();
                for(char s : map[index].toCharArray()){
                    rst.add( last + s);
                }
            }
        }
        return rst;
    }
    
    
  // ======================================================================================================================================= 
    
    //2. DFS 
     public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });        
        
        StringBuilder sb = new StringBuilder();
        
        dfs(digits, result, map, sb);
        
        return result;
    }
    
    private void dfs(String digits, List<String> result, Map<Character, char[]> map, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            result.add(new String(sb));
            return;
        }
        
        for (char c : map.get(digits.charAt(sb.length()))) {
map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            dfs(digits, result, map, sb);
            sb.setLength(sb.length() - 1);
        }
    }


}

