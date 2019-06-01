package vorovque.bot.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vorovque.bot.demo.TelegaApi.Vorovque;
import vorovque.bot.demo.dao.SystemDAO;
import vorovque.bot.demo.pojo.d3posts.D3postsPojo;
import vorovque.bot.demo.pojo.d3posts.Post;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Sheduler {

    @Value("${sheduler.update-new-posts}")
    private int checkInterval;

    @Autowired
    SystemDAO systemDAO;

    @Autowired
    Vorovque vorovque;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3600000)
    public void insertNewPost() {

        ObjectMapper mapper = new ObjectMapper();
        String d3Posts_byRating_json = HttpUtil.d3ByRating();
        String d3Posts_Gifs = HttpUtil.getD3Gif();
        D3postsPojo d3Posts = null;
        D3postsPojo d3PostsGifs = null;
        try {
            d3Posts = mapper.readValue(d3Posts_byRating_json, D3postsPojo.class);
            d3PostsGifs = mapper.readValue(d3Posts_Gifs, D3postsPojo.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Post> posts = d3Posts.getPosts();
        posts.addAll(d3PostsGifs.getPosts());
        for (Post p : posts){
           String s = "";
            try {
                p.getData().setText(p.getData().getText().replace("'",""));
                p.getData().setTitle(p.getData().getTitle().replace("'",""));
                s = mapper.writeValueAsString(p);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            systemDAO.insertD3Post(p.getId(),s);
        }


        System.out.println("checkInterval "+checkInterval);
        System.out.println("The time is now {}"+ dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 1800000)
    public void sendNewPosts(){
        List<Post> newPosts = systemDAO.getNewPosts();
        if (newPosts != null && newPosts.size() > 0){
            vorovque.sendMe(newPosts.get(0));
            systemDAO.setPostPosted(newPosts.get(0));
        }

    }

}
