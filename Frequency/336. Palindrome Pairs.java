//两个字符串组成回文有几种情况
// –第一个字符串是回文， 第二个字符串是空字符串， 比如 s1=“aba”, s2=""
// –第二个字符串和第二个字符是反过来的， 比如s1=“abcd”, s2=“dcba”
// –第一个个字符串的左边部分本身已经是回文， 然后右边部分和第二个字符串是回文， s1=“abagf”, s2=“fg”
// –第一个个字符串的右边部分本身已经是回文， 然后左边部分和第二个字符串是回文, s1=“gfaba”, s2=“fg”

// 情况分析清楚以后，针对每个情况逐个判断， 然后提前建好hashmap以后判断就好。
// 细节部分是不要忘记空字符串的情况， 然后针对整个字符串反过来的情况，不要有重复。


class Solution {
    // time: O(N*K^2) : N是数组的长度， K是数组字符串的平均长度
    // space: O(N) -- List
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> emptyIndex = new ArrayList<>();
        Map<String, Integer> reverseIndexMap = new HashMap<>();
        
        // build reverseIndexMap and emptyIndex List
        for (int i = 0; i < words.length; i++) {
            reverseIndexMap.put(new StringBuilder(words[i]).reverse().toString(), i);
            if (words[i].length() == 0) {
                emptyIndex.add(i);
            } 
        }
        
        
        for (int j = 0; j < words.length; j++) {
            
            //1.第一个字符串是回文， 第二个字符串是空字符串， 比如 s1=“aba”, s2=""
            if (isPali(words[j]) && words[j].length() > 0) { ////注意要验证是不是空串
                for (int i : emptyIndex) {
                    rst.add(Arrays.asList(j, i));
                    rst.add(Arrays.asList(i, j));
                }
            }
            
            //2. check full word reverse  "abc"   "cba"
            //第二个字符串和第二个字符是反过来的， 比如s1=“abcd”, s2=“dcba”
            int index = reverseIndexMap.getOrDefault(words[j], - 1);
            if (index >= 0 && index != j) {
                rst.add(Arrays.asList(j, index));
            }
            
            //3. check part word          
            // "bdbab"  "ba" : 第一个个字符串的左边部分本身已经是回文， 然后右边部分和第二个字符串是回文
            // "abbdb"  "ba" : 第一个个字符串的右边部分本身已经是回文， 然后左边部分和第二个字符串是回文
            for (int k = 1 ; k < words[j].length(); k++) {
                String leftPart = words[j].substring(0, k);
                String rightPart = words[j].substring(k);
                if (isPali(leftPart)) {
                    int leftIndex = reverseIndexMap.getOrDefault(rightPart, -1);
                    if (leftIndex >= 0 && leftIndex != j) {
                        rst.add(Arrays.asList(leftIndex, j));
                    }
                }
                if (isPali(rightPart)) {
                    int rightIndex = reverseIndexMap.getOrDefault(leftPart, -1);
                    if (rightIndex >= 0 && rightIndex != j) {
                        rst.add(Arrays.asList(j, rightIndex));
                    }
                }
            }
        }        
        return rst;
    }
    
    private boolean isPali(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
