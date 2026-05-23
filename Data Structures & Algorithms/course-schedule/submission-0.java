class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
        Do Topological sorting: think of this problem as graph and remove the node at the outermost (no incoming node) to the innermost
        If at the end no node have incoming node, means there is no cycle. which mean the output is true

        1. Initiate incomingNode list containing the count how many node is connected to each node
        2. Initiate adjMatrix list containing what node does each node is connected to
        3. Add the node that's doesn't have incoming node to a queue (outermost node)
        4. remove the node. check what node the removed node is connected to and decrease the incoming count
        5. if incoming count == 0, add node to the queue
        6. process all
        7. at the end, check if the incoming node count is empty for all node. If yes, then there's no cycle
        **/

        int[] incNode = new int[numCourses];
        List<Integer>[] adjMatrix = new ArrayList[numCourses];
        int doneCourses = 0;

        for (int i = 0;i<numCourses;i++) {
            adjMatrix[i] = new ArrayList<>();
        }

        for (int[] req: prerequisites) {
            incNode[req[0]]++;
            adjMatrix[req[1]].add(req[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i=0;i<incNode.length;i++) {
            if (incNode[i] == 0) {
                queue.offer(i);
                doneCourses++;
            }
        }

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();

            for (int neighbor:adjMatrix[currCourse]) {
                incNode[neighbor]--;
                if (incNode[neighbor] == 0) {
                    doneCourses++;
                    queue.offer(neighbor);
                }
            }
        }

        
        return doneCourses == numCourses;
    }
}
