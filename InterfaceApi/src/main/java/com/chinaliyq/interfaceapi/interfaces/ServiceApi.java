package com.chinaliyq.interfaceapi.interfaces;

import com.chinaliyq.interfaceapi.beans.Person;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: liyq
 * @Description: SpringCloudFour
 * @Date: 2021/4/30 - 17:44
 * @Version: 1.0
 **/
//@RequestMapping("/Service")
public interface ServiceApi {
    @GetMapping("/alive")
    String alive();

    @GetMapping("/getMap")
    Map getMap();

    @GetMapping("/getPerson1")
    Person getPerson1();

    @GetMapping("/getPerson2")
    Person getPerson2(@RequestParam("name") String name);

    @PostMapping("/postPerson")
    Person postPerson(@RequestBody Person person);

}
