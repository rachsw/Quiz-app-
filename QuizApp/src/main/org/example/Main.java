import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
@EnableFeignClients
@ComponentScan(basePackages = "org.example")
public class Main {

    @Autowired
    private TriviaApiClient triviaApiClient;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Rachel!";
    }

    @GetMapping("/trivia")
    public TriviaResponse getTriviaQuestions() {
        return triviaApiClient.getTriviaQuestions(10);
    }
}