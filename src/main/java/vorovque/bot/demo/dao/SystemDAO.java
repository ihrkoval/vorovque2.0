package vorovque.bot.demo.dao;

import vorovque.bot.demo.pojo.d3posts.Post;

import java.util.List;

public interface SystemDAO {
    public void initialize();
    public void insertD3Post(int postId, String postJson);
    public List<Post> getNewPosts();
    public void setPostPosted(Post post);
    public List<Post> getAllPosts();
    public Post getPostById(int id);
}
