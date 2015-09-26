package us.pdavidson.sample.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody
    String respond(){
        return "Hello to you friend\n\n";
    }

}
