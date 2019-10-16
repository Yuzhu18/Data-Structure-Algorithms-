//https://www.geeksforgeeks.org/balanced-expression-replacement/
// valid parathesis Follow-up
// recurisive 方法

static boolean isMatching(char a, char b) {
        if ((a == '{' && b == '}')
                || (a == '[' && b == ']')
                || (a == '(' && b == ')') || a == 'X') {
            return true;
        }
        return false;
    }

    // Recursive function to check if given expression is balanced or not.
    static boolean isBalanced(String s, Stack<Character> ele, int ind) {

        // Base case.
        // If the string is balanced then all the opening brackets had been popped and stack should be empty after string is traversed completely.
        if (ind == s.length()) {
            return ele.isEmpty();
        }

        // variable to store element at the top of the stack.
        char topEle;

        // variable to store result of recursive call.
        boolean res;

        // Case 1: When current element is an opening bracket then push that element in the stack.
        if (s.charAt(ind) == '{'
                || s.charAt(ind) == '('
                || s.charAt(ind) == '[') {
            ele.push(s.charAt(ind));
            return isBalanced(s, ele, ind + 1);
        } 
        // Case 2: When current element is a closing bracket then check for matching bracket at the top of the stack.
        else if (s.charAt(ind) == '}'
                || s.charAt(ind) == ')'
                || s.charAt(ind) == ']') {

            // If stack is empty then there is no matching opening bracket for current closing bracket and the expression is not balanced.
            if (ele.size() == 0) {
                return false;
            }

            topEle = ele.pop();

            // Check bracket is matching or not.
            if (!isMatching(topEle, s.charAt(ind))) {
                return false;
            }

            return isBalanced(s, ele, ind + 1);
        } 
        // Case 3: If current element is 'X' then check for both the cases when 'X' could be opening or closing bracket.
        else if (s.charAt(ind) == 'X') {
            // 分两种情况，一种把X当作左边的括号，一种把X当作右边的括号
            // 1. 把X当成左括号，直接push进stack里
            Stack<Character> tmp = new Stack<Character>();
            //because in java, direct assignment copies only reference and not the whole object
            tmp.addAll(ele);
            tmp.push(s.charAt(ind));
            res = isBalanced(s, tmp, ind + 1);
            if (res) {
                return true;
            }
            if (ele.isEmpty()) {
                return false;
            }
            // 把X当成右括号，匹配stack top的任意值
            ele.pop();
            return isBalanced(s, ele, ind + 1);
        }
        return true;
    }

    // main function
    public static void main(String[] args) {

        String s = "{(X}[]";
        String s1 = "{(X[X])}";
        Stack<Character> ele = new Stack<Character>();

        if (isBalanced(s1, ele, 0)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
