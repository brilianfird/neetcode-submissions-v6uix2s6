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
    private int currSize;
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
        moveToHead(newNode);
        keyToNodeMap.put(key, newNode);

        this.currSize++;

        if (this.currSize > this.capacity) {
            Node poppedNode = popTail();
            keyToNodeMap.remove(poppedNode.key);
            this.currSize--;
        }

    }

    private Node popTail() {
        Node toReturn = tail.prev;
        this.tail.prev.prev.next = this.tail;
        this.tail.prev = this.tail.prev.prev;
        toReturn.prev = null;
        toReturn.next = null;
        return toReturn;
    }

    private void moveToHead(Node node) {
        if (node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;
        this.head.next = node;
    }
}
