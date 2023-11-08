import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
public class MyApplication {
//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(MyApplication.class, args);
    }
}