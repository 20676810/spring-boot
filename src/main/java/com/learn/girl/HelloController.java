package com.learn.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/girls")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value={"/say/{id}","/hi"},method = RequestMethod.GET)
    @GetMapping(value={"/say/{id}","/hi/{id}"})
    public String say(@PathVariable("id") Integer id, @RequestParam(value = "name",defaultValue = "Gao",required = false) String name){
        return "id:"+id+name;
        //return  girlProperties.getCupSize();
        //return "index";
    }
}
