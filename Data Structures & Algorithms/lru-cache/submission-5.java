class Node {
    public int key;
    public int value;
    public Node next;
    public Node prev;

    public Node() {

    }
     
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> keyToNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.keyToNodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1;
        }

        Node node = keyToNodeMap.get(key);
        moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            moveToHead(node);
            node.value = value;
            return;
        }

        Node newNode = new Node(key, value);
        addToHead(newNode);
        keyToNodeMap.put(key, newNode);


        if (this.keyToNodeMap.size() > this.capacity) {
            Node tailNode = this.tail.prev;
            remove(tailNode);
            keyToNodeMap.remove(tailNode.key);        
        }

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;
        this.head.next = node;
    }

    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }
}
