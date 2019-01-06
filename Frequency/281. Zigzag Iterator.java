public class ZigzagIterator {
    // 利用Iterator

    Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator>();
        if(!v1.isEmpty()){ queue.offer(v1.iterator()); }
        if(!v2.isEmpty()){ queue.offer(v2.iterator()); }
        
    }

    public int next() {
        Iterator poll = queue.poll();
        int rst = (Integer)poll.next();
        // 如果不是null,就继续加入queue
        if(poll.hasNext()){
            queue.offer(poll);
        }
        return rst;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
