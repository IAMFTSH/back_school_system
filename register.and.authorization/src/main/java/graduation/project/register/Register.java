package graduation.project.register;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 邝明山
 * on 2020/10/29 15:35
 */

@SpringBootApplication
public class Register {
    public static void main(String[] args) {
        SpringApplication.run(Register.class, args);
    }
}
