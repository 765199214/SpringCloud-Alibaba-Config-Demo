package cn.linkpower.global;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;

public class HandlerGlobal {

    public static JSONObject handler1(String msg,BlockException e){
        JSONObject json = new JSONObject();
        json.put("code",300);
        json.put("msg","请求降级！----1");
        return json;
    }

    public static JSONObject handler2(String msg,BlockException e){
        JSONObject json = new JSONObject();
        json.put("code",300);
        json.put("msg","请求降级！----2");
        return json;
    }
}
