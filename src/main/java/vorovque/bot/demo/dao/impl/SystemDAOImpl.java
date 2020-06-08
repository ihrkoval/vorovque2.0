package vorovque.bot.demo.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vorovque.bot.demo.dao.SystemDAO;
import vorovque.bot.demo.pojo.d3posts.Post;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SystemDAOImpl implements SystemDAO {

    @Autowired
    DataSource dataSource;

    Statement statement;

    @Override
    public void initialize() {
        try {
           statement = dataSource.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql =  "CREATE TABLE IF NOT EXISTS D3_POSTS_JSON" +
                "(id INTEGER not NULL, " +
                " post_json VARCHAR(150000), " +
                " isposted INTEGER, " +
                " insert_date DATE, " +
                " PRIMARY KEY ( id ))";
        
        String cleraPosts = "delete from d3_posts_json;";
        try {
            statement.executeUpdate(sql);
            statement.executeUpdate(cleraPosts);
        } catch (SQLException e) {
            System.out.println("ошибка инициализации БД");
            e.printStackTrace();
        }
    }

    @Override
    public void insertD3Post(int postId, String postJson){
        String sql = "SELECT id FROM D3_POSTS_JSON where id = "+postId; //TODO table names in settings file
        ResultSet rs = null;
        int isRs = 0;

        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                isRs=1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




        if (isRs == 0){
            java.sql.Date sqlDate = new java.sql.Date(Instant.now().toEpochMilli());
            postJson = postJson.replace("'","");
            String insertPost = "INSERT INTO D3_POSTS_JSON " + " VALUES("+postId+", '"+postJson+"' , "+0+" , '"+sqlDate+"')";
            System.out.println(insertPost);
            try {
                statement.executeUpdate(insertPost);
            } catch (SQLException e) {
                System.out.println("FAIL to insert D3 post");
                e.printStackTrace();
            }
        }


    }

    @Override
    public List<Post> getNewPosts(){
        List<Post> newPosts = new ArrayList<Post>();
        String sql = "SELECT * FROM D3_POSTS_JSON where isposted = 0";
        ObjectMapper mapper = new ObjectMapper();

        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                try {
                    Post p = mapper.readValue(rs.getString("post_json"), Post.class);
                    newPosts.add(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newPosts;

    }

    @Override
    public Post getPostById(int id){
        String sql = "SELECT * FROM D3_POSTS_JSON WHERE ID = "+id;
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                try {
                    return mapper.readValue(rs.getString("post_json"), Post.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }

    @Override
    public List<Post> getAllPosts(){
        List<Post> newPosts = new ArrayList<Post>();
        String sql = "SELECT * FROM D3_POSTS_JSON";
        ObjectMapper mapper = new ObjectMapper();

        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                try {
                    Post p = mapper.readValue(rs.getString("post_json"), Post.class);
                    newPosts.add(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newPosts;

    }

    @Override
    public void setPostPosted(Post post){
        List<Post> newPosts = new ArrayList<Post>();
        String sql = "update D3_POSTS_JSON  set isposted = 1 where id = "+post.getId();
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
