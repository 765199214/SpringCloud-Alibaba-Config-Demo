package cn.linkpower.controller;

import cn.linkpower.servive.ServiceImpl;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    /**
     * 降级测试
     * @param name
     * @return
     */
    @RequestMapping("/jiangji")
    public String jiangji(@RequestParam("name") String name){
        //当请求参数为 1 时，响应延迟600ms 也就是RT可以配置允许时间比这个数低的值
        if("1".equalsIgnoreCase(name)){
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("请求的name：{},时间为：{}",String.valueOf(name),new Date().getTime());
        return "jiangji test name="+String.valueOf(name)+" 当前时间："+new Date().getTime();
    }

    /**
     * 异常触发熔断降级测试
     */
    int a = 0;
    @RequestMapping("/exct")
    public String exct(){
        a ++ ;
        if(a % 3 == 0){
            //模拟异常
            throw new RuntimeException("请求取余数为0了");
        }
        return "异常导致的熔断降级测试";
    }

    /**
     * 热点规则测试项
     * @param p1
     * @param p2
     * @return
     */
    @RequestMapping("/hostkey")
    //名称唯一 但 热点规则 必须需要此项配置，无此注解不生效
    @SentinelResource(value = "hostkey",blockHandler = "fallback_hostkey")
    public String testHotKey(@RequestParam(value="p1",required = false) String p1,
                             @RequestParam(value="p2",required = false) String p2){

        return "---- test Hot Key ----";
    }
    // 修改sentinel 降级的默认回执方法
    public String fallback_hostkey(String p1, String p2, BlockException blockException){
        return "限流咯。。。。";
    }

    /**
     * 热点规则测试项
     * @param p1
     * @param p2
     * @return
     */
    @RequestMapping("/hostkey2")
    //名称唯一 但 热点规则 必须需要此项配置，无此注解不生效
    @SentinelResource(value = "hostkey",blockHandler = "fallback_hostkey",fallback = "except_fallback")
    public String testHotKey2(@RequestParam(value="p1",required = false) String p1,
                             @RequestParam(value="p2",required = false) String p2){
        int a = 10/0;
        return "---- test Hot Key ----";
    }

    public String except_fallback(String p1, String p2){
        return "出现了异常。。。。。";
    }
}

