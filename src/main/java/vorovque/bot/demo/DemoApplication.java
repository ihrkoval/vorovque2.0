package vorovque.bot.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import vorovque.bot.demo.TelegaApi.Vorovque;
import vorovque.bot.demo.dao.SystemDAO;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String pwd;

    @Value("${spring.datasource.driver-class-name}")
    private String drvr;


    @Autowired
    SystemDAO systemDAO;

    Vorovque vorovque;

    @Bean
    public DataSource dataSource() throws SQLException {
        if (dbUrl == null || dbUrl.isEmpty()) {
            return new HikariDataSource();
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            if (username != null)
            config.setUsername(username);
            if (pwd != null)
            config.setPassword(pwd);
            config.setDriverClassName(drvr);
            return new HikariDataSource(config);
        }
    }

    @Bean
    public Vorovque vorovque(){
        ApiContextInitializer.init();
        vorovque = new Vorovque();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(vorovque);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return vorovque;
    }


    @Bean
    public String initialize() throws SQLException {
                systemDAO.initialize();

            return "initialize bean initializing";
    }
}
