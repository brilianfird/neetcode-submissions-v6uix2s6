/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer, Node> intToNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        intToNodeMap.put(node.val, newNode);
        for (Node neighbor:node.neighbors) {
            if (intToNodeMap.containsKey(neighbor.val)) {
                newNode.neighbors.add(intToNodeMap.get(neighbor.val));
                continue;
            }

            newNode.neighbors.add(cloneGraph(neighbor));
        }    

        return newNode;
    }
}