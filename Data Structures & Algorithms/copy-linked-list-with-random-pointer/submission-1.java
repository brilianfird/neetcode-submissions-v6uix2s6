/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<String, Node> objToNodeMap = new HashMap<>();
      
        Node dummyNode = new Node(0);
        Node copyNode = dummyNode;
        Node currNode = head;
        while (currNode != null) {
            copyNode.next = new Node(currNode.val);
            copyNode = copyNode.next;
            objToNodeMap.put(currNode.toString(), copyNode);
            currNode = currNode.next;
        }

        currNode = head;
        copyNode = dummyNode.next;

        while (currNode != null) {
            if (currNode.random != null) {
                copyNode.random = objToNodeMap.get(currNode.random.toString());
            }

            copyNode = copyNode.next;
            currNode = currNode.next;
        }


        return dummyNode.next;
    }
}
