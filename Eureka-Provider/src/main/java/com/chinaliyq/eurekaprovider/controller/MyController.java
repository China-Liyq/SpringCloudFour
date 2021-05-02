package com.chinaliyq.eurekaprovider.controller;

import com.chinaliyq.interfaceapi.beans.Person;
import com.chinaliyq.interfaceapi.interfaces.ServiceApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyq
 * @Description: SpringCloudFour
 * @Date: 2021/4/30 - 18:02
 * @Version: 1.0
 **/
@RestController
public class MyController implements ServiceApi {
    @Value("${server.port}")
    String port;

    @GetMapping("/getMap1")
    public Map<Integer,String> getMap1(Integer id){
        System.out.println(id);
        System.out.println("端口：" + port);
        return Collections.singletonMap(id,"kkk");
    }

    @GetMapping("/getMap2")
    public Map<Integer,String> getMap2(Integer id,String name){
        System.out.println(id);
        System.out.println("端口：" + port);
        return Collections.singletonMap(id,name);
    }

    @GetMapping("/getMap3")
    public Map<Integer,String> getMap3(@RequestParam Map<String,Object> map){
        System.out.println(map);
        System.out.println("端口：" + port);
        return Collections.singletonMap(Integer.valueOf(map.get("id").toString()),
                map.get("name").toString());
    }
    @PostMapping("/postMap")
    public Map<Integer,String> postMap(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println("端口：" + port);
        return Collections.singletonMap(Integer.valueOf(map.get("id").toString()),
                map.get("name").toString());
    }

    @Override
    public String alive() {
        System.out.println("开始访问端口：" + port);
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("结束访问端口：" + port);
        return "provider----,端口：" + port;
    }

    @Override
    public Map getMap() {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(999);
        map.put("Map端口:",port);
        return map;
    }

    @Override
    public Person getPerson1() {
        Person person = new Person("liuq", '男', 20);
        System.out.println("端口：" + port);
        System.out.println(person);
        return person;
    }

    @Override
    public Person getPerson2(String name) {
        Person person = new Person("liuq", '男', 20);
        System.out.println("端口：" + port);
        person.setName(name);
        System.out.println(person);
        return person;
    }

    @Override
    public Person postPerson(Person person) {
        System.out.println(person);
        System.out.println("端口：" + port);
        return person;
    }

}
