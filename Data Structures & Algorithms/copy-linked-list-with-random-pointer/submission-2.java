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
        Map<Node, Node> objToNodeMap = new HashMap<>();
      
        Node currNode = head;

        while (currNode != null) {
            objToNodeMap.put(currNode, new Node(currNode.val));
            currNode = currNode.next;
        }

        currNode = head;

        while (currNode != null) {
            Node copy = objToNodeMap.get(currNode);
            copy.next = objToNodeMap.get(currNode.next);
            copy.random = objToNodeMap.get(currNode.random);
            currNode = currNode.next;
        }

        return objToNodeMap.get(head);
    }
}
