package graduation.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 邝明山
 * on 2020/11/22 19:29
 */
@SpringBootApplication
@ServletComponentScan("graduation.project.config.filters")
public class Login {
    public static void main(String[] args) {
        SpringApplication.run(Login.class, args);
    }
}