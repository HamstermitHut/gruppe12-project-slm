package fhtw.gruppe12.projectslm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    final String std_mes = "Everything works as expected";
    String var_mes = null;

    @GetMapping("/api/message")
    public String message(){
        if (var_mes != null) {
            return var_mes;
        } else {
            return std_mes;
        }
    }
}
