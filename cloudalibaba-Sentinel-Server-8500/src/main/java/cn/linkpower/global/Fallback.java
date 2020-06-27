package cn.linkpower.global;

import com.alibaba.fastjson.JSONObject;

public class Fallback {
    public static JSONObject fallback1(String msg){
        JSONObject json = new JSONObject();
        json.put("code",300);
        json.put("msg","fallback1 请求降级！");
        return json;
    }

    public static JSONObject fallback2(String msg){
        JSONObject json = new JSONObject();
        json.put("code",300);
        json.put("msg","fallback2 请求降级！");
        return json;
    }
}
