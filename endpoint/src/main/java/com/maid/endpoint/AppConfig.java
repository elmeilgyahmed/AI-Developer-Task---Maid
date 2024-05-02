package com.maid.endpoint;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.sqlite.SQLiteDataSource;
import javax.sql.DataSource;


@Configuration
// Indicates that this class contains bean definitions that should be registered in the Spring application context
public class AppConfig {

    @Bean
    // Defines a bean of type RestTemplate in the Spring application context
    public RestTemplate restTemplate() {
        return new RestTemplate();
    
    }


    @Bean
    // Defines a bean of type DataSource in the Spring application context
    public DataSource dataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        String userHome = System.getProperty("user.home");
        String databasePath = userHome + "/Maids Project/Dataset/test-test.db";
        dataSource.setUrl("jdbc:sqlite:" + databasePath);
        return dataSource;
    }


    
}
