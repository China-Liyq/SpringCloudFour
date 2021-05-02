package com.chinaliyq.eurekaconsumer1.controller;

import com.chinaliyq.eurekaconsumer1.interfaces.ConsumerApi;
import com.chinaliyq.interfaceapi.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: liyq
 * @Description: SpringCloudFour
 * @Date: 2021/4/30 - 17:54
 * @Version: 1.0
 **/
@RestController
public class MainController {
    @Value("${server.port}")
    String port;

    @Autowired
    ConsumerApi myApi;

    @GetMapping("/getMap1")
    Map<Integer,String>  getMap1(Integer id){
        System.out.println(id + "; -- consumer端口：" + port);
        return myApi.getMap1(id);
    };

    @GetMapping("/getMap2")
    Map<Integer,String>  getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name){
        System.out.println("consumer端口：" + port);
        return myApi.getMap2(id,name);
    };

    @GetMapping("/getMap3")
    Map<Integer,String>  getMap3(@RequestParam Map<String,Object> map){
        System.out.println(map);
        return myApi.getMap3(map);
    };

    @GetMapping("/postMap")
    Map<Integer,String>  getMap4(@RequestParam Map<String,Object> map){
        System.out.println(map);
        return myApi.postMap(map);
    };


//    public String back(){
//        return "请求失败~bbb...";
//    }
//    @HystrixCommand(fallbackMethod = "back")
    @GetMapping("/getAlive")
    String getAlive(){
        System.out.println("consumer端口：" + port);
        return "consumer端口：" + port + ";" + myApi.alive();
    };

    @GetMapping("/getMap")
    Map getMap(){
        Map map = myApi.getMap();
        System.out.println("端口：" + port+ ";"+ map);
        return map;
    };

    @GetMapping("/getPerson1")
    Person getPerson1(){
        System.out.println("端口：" + port);
        return myApi.getPerson1();
    };

    @GetMapping("/getPerson2")
    Person getPerson2(@RequestParam("name") String name){
        System.out.println("端口：" + port);
        return myApi.getPerson2(name);
    };

    @GetMapping("/postPerson")
    Person postPerson(@RequestParam("name") String name,
                      @RequestParam("sex") char sex,
                      @RequestParam("age") int age){
        System.out.println(55);
        Person person = new Person(name, sex, age);
        System.out.println(person);
        System.out.println("端口：" + port);
        return myApi.postPerson(person);
    };


}
