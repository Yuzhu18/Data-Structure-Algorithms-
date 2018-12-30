class LRUCache {
    // find answer to a question :   hashmap
    // adjust the timestamp of a particular entry
    // find and delete the oldest entry
    //insert an entry as the newest   : doubly linked list
    
    
    static class Node<K, V>{
        Node<K, V> next;
        Node<K, V> prev;
        K key;
        V value;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
        void update(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    
    
    
    //maintain the key and its relation node in doubly linked list
    private Map<Integer, Node<Integer, Integer>> map;
    //final limit size of cache
    private final int limit;
    // record all the time the head and tail of doubly linkedlist 
    private Node<Integer, Integer> head;
    private Node<Integer, Integer> tail;
    
    
    public LRUCache(int capacity) {
        limit = capacity;
        map = new HashMap<Integer, Node<Integer, Integer>>();
    }
    
    public int get(int key) {
        Node<Integer, Integer> node = map.get(key);
        // map does has this key
        if(node == null){
            return -1;
        }
        // if exist, we should remove the current node to the head of linkedlist
        remove(node);
        append(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node<Integer, Integer> node = null;
        //1. if key already in the cache, we need update its value
        // and move it to the head (most recent position)
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            remove(node);
        //2. if the key is not in the cache and we still have space
        // we can add append a new node to head
        }else if(map.size() < limit){
            node = new Node<Integer, Integer>(key, value);
            
        // 3. if the key isn't in the cache, don't have space
        // we need to remove the tail and add new node to the head
        }else{
            node = tail;
            remove(node);
            node.update(key, value);
        }
        //add to head
        append(node);
    }
    
    private Node<Integer, Integer> remove(Node<Integer, Integer> node){
        //remove from map
        map.remove(node.key);
        //remove from linkedlist
        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        //update head / tail
        if(node == head){
           head = head.next; 
        }
        if(node == tail){
            tail = tail.prev;
        }
        node.next = node.prev = null;
        return node;
    }
    
    // put the node into the head of linkedlist
    private Node<Integer, Integer> append(Node<Integer, Integer> node){
        map.put(node.key, node);
        
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }
    

}

 
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
