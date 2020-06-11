package cn.linkpower.controller;

import cn.linkpower.servive.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test1")
    public String test1(){
        return "----this is test1";
    }

    @RequestMapping("/test2")
    public String test2(){
        return "----this is test2";
    }

    /**
     * 模拟  阈值类型  为  线程数
     * @return
     */
    @RequestMapping("/test3")
    public String test3(){
        // 每次请求过来，都延时800毫秒做处理
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----this is test3";
    }

    /**
     *链路demo
     */

    @Autowired
    private ServiceImpl serviceImpl;

    @RequestMapping("/message1")
    private String message1(){
        serviceImpl.message();
        return "lianlu  message1";
    }

    @RequestMapping("/message2")
    private String message2(){
        serviceImpl.message();
        return "lianlu  message2";
    }

    /**
     * 队列等待模式测试
     */
    @RequestMapping("/test4")
    public String test4(){
        log.info("当前线程执行信息：{}",Thread.currentThread().getName());
        return "duilie wait test4";
    }
}

