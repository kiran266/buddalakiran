package com.example.test.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController("/consume")
public class DemoController {

   @Autowired
   RestTemplate restTemplate;

    @RequestMapping(path="/{userName}", method = RequestMethod.GET)
    public ResponseObject getData()  {
        String jsonOutput = restTemplate.getForObject("https://api.github.com/users/joshuadeguzman", String.class);

        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = jsonParser.parseMap(jsonOutput);
        ResponseObject rs = new ResponseObject();
        if(map.containsKey("blog")) {
            rs.setBlog(map.get("blog").toString());
        }
        if(map.containsKey("location")){
            rs.setLocation(map.get("location").toString());
        }

        return rs;
        //return ResponseEntity.ok().body("Test");
    }
}
