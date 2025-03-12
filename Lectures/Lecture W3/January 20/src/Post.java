public class Post {
    private String postId;
    private String postContent;

    private static int postCount = 0;

    public Post(String postId, String postContent) {
        this.postId = postId;
        this.postContent = postContent;

        postCount++;
    }

    public Post(String postContent) {
        // Make sure the the copy constructor is the first line, otherwise will not work
        this("p" + postCount, postContent);
    }

    public Post() {
        this("p" + postCount, "No caption");
    }

    public static int getPostCount() {
        return postCount;
    }

    public Post clone() {
        return new Post(this.postId, this.postContent);
    }
}
