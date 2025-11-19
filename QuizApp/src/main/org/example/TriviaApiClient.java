import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "triviaApi", url = "https://opentdb.com")
public interface TriviaApiClient {

    @GetMapping("/api.php")
    TriviaResponse getTriviaQuestions(@RequestParam("amount") int amount);
}