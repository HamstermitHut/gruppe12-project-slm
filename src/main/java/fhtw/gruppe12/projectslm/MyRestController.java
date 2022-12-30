package fhtw.gruppe12.projectslm;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @GetMapping("/api/message/set")
    public String set(String m){
        this.var_mes=m;
        return "ok";
    }

    @GetMapping("/api/message/reset")
    public String reset() {
        this.var_mes= null;
        return "ok";
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getHTML() {
        if (var_mes != null) {
            return "<html>\n" + "<header><title>"+var_mes+"</title></header>\n" +
                    "<body style='background-color:#F08080; text-align:center'>\n" +
                    "<h2>Maintenance Monitor</h2><br>\n"+ var_mes + "\n" +
                    "</body>\n" + "</html>";
        } else {
            return "<html>\n" + "<header><title>"+std_mes+"</title></header>\n" +
                    "<body  style='background-color:#8FBC8F; text-align:center'>\n" +
                    "<h2>Maintenance Monitor</h2><br>\n"+ std_mes +"\n" + "</body>\n" +
                    "</p></html>";
        }
    }
}
