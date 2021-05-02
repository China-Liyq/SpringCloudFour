package com.chinaliyq.eurekaconsumer1.utils;

import com.chinaliyq.eurekaconsumer1.interfaces.ConsumerApi;
import com.chinaliyq.interfaceapi.beans.Person;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: liyq
 * @Description: SpringCloudFour
 * @Date: 2021/5/1 - 16:21
 * @Version: 1.0
 **/
@Component
public class WebError implements FallbackFactory<ConsumerApi> {
    @Override
    public ConsumerApi create(Throwable throwable) {
        return new ConsumerApi() {
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

                return Collections.singletonMap(1,"连接错误！");
            }

            @Override
            public String alive() {
                System.out.println("--------开始-----");
                System.out.println(throwable.getLocalizedMessage());
                System.out.println("-----");
                throwable.printStackTrace();
                System.out.println("-------中间------");
                System.out.println(throwable);
                if (throwable instanceof ArithmeticException){
                    return "分母不能为零";
                }else if (throwable instanceof RuntimeException){
                    return "服务错误";
                }else if (throwable instanceof HystrixTimeoutException){
                    return "HystrixTimeoutException";
                }
                return throwable.getLocalizedMessage() + "结束";
            }

            @Override
            public Map getMap() {
                return null;
            }

            @Override
            public Person getPerson1() {
                return null;
            }

            @Override
            public Person getPerson2(String name) {
                return null;
            }

            @Override
            public Person postPerson(Person person) {
                return null;
            }
        };
    }
}
