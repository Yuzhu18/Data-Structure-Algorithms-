// use two stack
// store the relational current max value in the maxStack
// popMax(): O(n) 需要遍历一遍，找到max value
// other operation are all O(1)

class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;
    
    public MaxStack() {
        stack = new ArrayDeque<Integer>();
        maxStack = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        int curMax = stack.isEmpty() ? Integer.MIN_VALUE : maxStack.peekFirst();
        if (x > curMax) {
            curMax = x;
        }
        stack.offerFirst(x);
        maxStack.offerFirst(curMax);
    }
    
    public int pop() {
        maxStack.pollFirst();
        return stack.pollFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int peekMax() {
        return maxStack.peekFirst();
    }
    
    public int popMax() {
        Deque<Integer> temp = new ArrayDeque<>();
        int maxValue = maxStack.peekFirst();
        while (!stack.isEmpty()) {
            int cur = stack.pollFirst();
            maxStack.pollFirst();
            if (cur != maxValue) {
                temp.offerFirst(cur);
            } else {
                break;
            }
        }
        while (!temp.isEmpty()) {
            push(temp.pollFirst());
        }
        return maxValue;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
