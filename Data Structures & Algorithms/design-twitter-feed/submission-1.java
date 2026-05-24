class UserNode {
    public int userId;
    public Set<Integer> following;

    public UserNode(int userId) {
        this.userId = userId;
        this.following = new HashSet<>();
    }
}

class Twitter {

    private Map<Integer, UserNode> userToGraph;

    // userID -> timestamp, tweet
    private Map<Integer, Map<Integer, Integer>> userTweets;
    private int timestamp;


    public Twitter() {
        this.userToGraph = new HashMap<>();
        this.timestamp = 0;
        this.userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new HashMap<>());
        }

        if (!userToGraph.containsKey(userId)) {
            UserNode userNode = new UserNode(userId);
            userToGraph.put(userId, userNode);
        }
        userToGraph.get(userId).following.add(userId);

        userTweets.get(userId).put(timestamp, tweetId);
        timestamp++;
    }


    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        
        if (!this.userToGraph.containsKey(userId)) {
            return newsFeed;
        }

        // Create recent tweet
        PriorityQueue<int[]> recentTweet = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Add tweets
        UserNode userNode = userToGraph.get(userId);
        for (int following : userNode.following) {

            if (!userTweets.containsKey(following)) {
                continue;
            }

            Map<Integer, Integer> followingTweets = userTweets.get(following);

            for (Map.Entry<Integer, Integer> entrySet : followingTweets.entrySet()) {
                recentTweet.offer(new int[]{entrySet.getKey(), entrySet.getValue()});

                if (recentTweet.size() > 10) recentTweet.poll();
            }
        }

        // Sort tweet from the newest
        PriorityQueue<int[]> sortedTweet = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        while (!recentTweet.isEmpty()) {
            int[] timestampToTweet = recentTweet.poll();
            sortedTweet.offer(new int[]{timestampToTweet[0], timestampToTweet[1]});
        }

        while (!sortedTweet.isEmpty()) {
            newsFeed.add(sortedTweet.poll()[1]);
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userToGraph.containsKey(followerId)) {
            UserNode userNode = new UserNode(followerId);
            userToGraph.put(followerId, userNode);
        }

        userToGraph.get(followerId).following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !userToGraph.containsKey(followerId)) {
            return;
        }

        userToGraph.get(followerId).following.remove(followeeId);
    }
}
