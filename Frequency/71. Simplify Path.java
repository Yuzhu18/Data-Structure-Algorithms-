class Solution {
    // Time: O(n)   - loop once
    // Space: O(n)  - deque
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        } else if (path == "/") {
            return path;
        }
        
        String[] array = path.split("/");
        Deque<String> deque = new LinkedList<>();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollFirst();
                }
            } else if (!array[i].equals(".")  && !array[i].equals("..") && !array[i].equals("")) {
                deque.offerFirst(array[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollLast());
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
        
    }
}
