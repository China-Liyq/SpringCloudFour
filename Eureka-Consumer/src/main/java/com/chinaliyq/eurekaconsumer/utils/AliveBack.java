package com.chinaliyq.eurekaconsumer.utils;

import com.chinaliyq.eurekaconsumer.interfaces.ConsumerApi;
import com.chinaliyq.interfaceapi.beans.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: liyq
 * @Description: SpringCloudFour
 * @Date: 2021/5/1 - 15:52
 * @Version: 1.0
 **/
@Component
public class AliveBack implements ConsumerApi {
    @Override
    public Map<Integer, String> getMap1(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public String alive() {
        return "附件，，，资源紧张，加载需要时间..11.";
    }

    @Override
    public Map getMap() {

        return Collections.singletonMap("值：","附件，，，资源紧张，加载需要时间...");
    }

    @Override
    public Person getPerson1() {
        return null;
    }

    @Override
    public Person getPerson2(String name) {
        Person person = new Person();
        person.setName(name);
        return person;
    }

    @Override
    public Person postPerson(Person person) {
        System.out.println(person);
        person.setName("postPerson失败");
        return person;
    }
}
