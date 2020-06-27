package cn.linkpower.controller;

import cn.linkpower.global.Fallback;
import cn.linkpower.global.HandlerGlobal;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {

    @RequestMapping("/resources1")
    @SentinelResource(value = "resources1",blockHandler = "handler1")
    public JSONObject resources1(){
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("msg","请求成功！");
        return json;
    }

    public JSONObject handler1(BlockException e){
        JSONObject json = new JSONObject();
        json.put("code",300);
        json.put("msg","请求降级！");
        return json;
    }

    // ================= 异常操作
    @RequestMapping("/resources2")
    @SentinelResource(value = "resources2",blockHandler = "handler2",fallback = "fallback2")
    public JSONObject resources2(){
        int a = 10/0;
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("msg","请求成功！");
        return json;
    }

    public JSONObject fallback2(){
        JSONObject json = new JSONObject();
        json.put("code",300);
        json.put("msg","fallback2 请求降级！");
        return json;
    }

    public JSONObject handler2(BlockException e){
        JSONObject json = new JSONObject();
        json.put("code",300);
        json.put("msg","请求降级！");
        return json;
    }

    //============全局化调用
    @RequestMapping("/resources3")
    @SentinelResource(value = "resources3",
            blockHandlerClass = HandlerGlobal.class ,
            blockHandler = "handler2",
            fallbackClass = Fallback.class,
            fallback = "fallback1")
    public JSONObject resources3(String msg){
        if("1".equalsIgnoreCase(msg)){
            int a = 10/0;
        }
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("msg","请求成功！");
        return json;
    }
}
