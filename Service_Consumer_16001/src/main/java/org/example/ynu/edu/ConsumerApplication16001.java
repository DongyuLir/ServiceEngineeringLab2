package org.example.ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication16001 {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }//知道从哪里来
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication16001.class,args);
    }
}
