// 题目是要求用greedy的方式排版每一行，然后在单词之间均匀分布空格来填满每一行（除最后一行全部靠左）
// time: O(N * K) --N = words.length  -- K = maxWidth
// Space：O(1) --no extra space
//We start with left being the first word.
// findRight(): Then we greedily try to go as far right as possible until we fill our current line.

// Then we justify one line at a time.
// Justify(): In all cases we pad the right side with spaces until we reach max width for the line;

// 1.If it's one word then it is easy, the result is just that word.
// 2.If it's the last line then the result is all words separated by a single space.
// 3.Otherwise we calculate the size of each space evenly and if there is a remainder we          distribute an extra space until it is gone.


class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0; List<String> result = new ArrayList<>();
        // left, right 代表这一行最左和最右包含的word的index
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        
        return result;
    }
    
    public String justify(int left, int right, String[] words, int maxWidth) {
        // 如果这一行只有一个单词，那么这个单词在最左边，右边都是空格
        if (left == right) {
            return padRight(words[left], maxWidth);
        }
        
        // sum 是这行单词所占的总长度
        int sum = words[left].length();
        for (int i = left + 1; i <= right; i++) {
            sum += words[i].length();
        }
        
        //判断是不是最后一行
        // numWords 单词之间多少空隙
        boolean isLastLine = right == words.length - 1;
        int numWords = right - left;
        int numWhitespace = maxWidth - sum;
        
        int numSpacesBetween = isLastLine ? 1 : numWhitespace / numWords;
        int remainder = isLastLine ? 0 : numWhitespace % numWords;
        
        StringBuilder result = new StringBuilder(); 
        
        for (int i = left; i < right; i++) {
            result.append(words[i]);
            result.append(whitespace(numSpacesBetween));
            result.append(remainder-- > 0 ? " " : "");
        }
        
        result.append(words[right]);
        
        if (isLastLine) {
            return padRight(result.toString(), maxWidth);
        } else { 
            return result.toString();
        }
    }
    
    // 生成对应数量空格的string
    public String whitespace(int numSpacesBetween) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numSpacesBetween; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    //这个单词在最左边，右边都是空格
    public String padRight(String s, int maxWidth) {
        StringBuilder sb = new StringBuilder(s);
        sb.append(whitespace(maxWidth - s.length()));
        return sb.toString();
    }
    
    //找到当前行最右包含的word的index
    public int findRight(int left, String[] words, int maxWidth) {
        
        int right = left;
        int sum = words[right++].length();
        
        while (right < words.length && sum + 1 + words[right].length() <= maxWidth) {
            sum += (1 + words[right++].length());
        }
        
        return right - 1;
    }
}
