class Node {
    public Node() {

    }
    public Node next;
    public Node prev;
    public int key;
    public int val;
}

class LRUCache {

    private int capacity;
    private Map<Integer, Node> keyToNodeMap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNodeMap = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1;
        }

        Node node = keyToNodeMap.get(key);
        moveToHead(key);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            node.val = value;
            moveToHead(key);
            return;
        }

        Node node = new Node();
        node.key = key;
        node.val = value;
        this.keyToNodeMap.put(node.key, node);

        addToHead(node);
        if (this.capacity == 0) {
            this.keyToNodeMap.remove(this.tail.prev.key);
            removeTail();
            return;
        }
        capacity--;
    }

    private void addToHead(Node node) {
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }

    private void moveToHead(int key) {
        Node node = keyToNodeMap.get(key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = this.head.next;
        this.head.next.prev = node;

        this.head.next = node;
        node.prev = this.head;
    }
    
    private void removeTail() {
        this.tail.prev.prev.next = this.tail;
        this.tail.prev = this.tail.prev.prev;
    }
}
