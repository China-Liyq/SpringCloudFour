package com.chinaliyq.eurekaconsumer.interfaces;

import com.chinaliyq.eurekaconsumer.utils.AliveBack;
import com.chinaliyq.eurekaconsumer.utils.WebError;
import com.chinaliyq.interfaceapi.interfaces.ServiceApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: liyq
 * @Description: SpringCloudFour
 * @Date: 2021/4/30 - 17:52
 * @Version: 1.0
 **/
//@FeignClient(name = "eureka-provider")
//@FeignClient(name = "eureka-provider",fallback = AliveBack.class)
@FeignClient(name = "eureka-provider",fallbackFactory = WebError.class)
public interface ConsumerApi extends ServiceApi {

    @GetMapping("/getMap1")
    Map<Integer,String>  getMap1(@RequestParam("id")Integer id);

    @GetMapping("/getMap2")
    Map<Integer,String>  getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer,String>  getMap3(@RequestParam Map<String,Object> map);

    @GetMapping("/postMap")
    Map<Integer,String>  postMap(Map<String,Object> map);
}
