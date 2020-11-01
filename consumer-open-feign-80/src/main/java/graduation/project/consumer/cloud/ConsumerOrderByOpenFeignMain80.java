package graduation.project.consumer.cloud;

import feign.Logger;
import graduation.project.consumer.exclude.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 邝明山
 * on 2020/10/9 16:42
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name="payment-service",configuration = MyselfRule.class)
public class ConsumerOrderByOpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderByOpenFeignMain80.class,args);
    }
    @Configuration
    public class FeignConfig {
        @Bean
        Logger.Level feignLoggerLevel(){
            return Logger.Level.FULL;
        }
    }
}
