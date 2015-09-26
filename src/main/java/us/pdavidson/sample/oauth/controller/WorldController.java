package us.pdavidson.sample.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {


    @RequestMapping("/world")
    public @ResponseBody String respond(){
        return "Hello to all the world\n\n";
    }

}
