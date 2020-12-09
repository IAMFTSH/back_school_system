package graduation.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 邝明山
 * on 2020/11/2 21:41
 */
@SpringBootApplication
@ServletComponentScan("graduation.project.filters")
public class Management {
    public static void main(String[] args) {
            SpringApplication.run(Management.class, args);
    }
}
