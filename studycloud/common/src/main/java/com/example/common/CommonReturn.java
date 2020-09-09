package com.example.common;

import java.util.HashMap;
import java.util.Map;

public class CommonReturn extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private CommonReturn() {
        super(DEFAULT_INITIAL_CAPACITY);
    }

//    public static CommonReturn error() {
//        return error(500, "未知异常，请联系管理员");
//    }

//    public static CommonReturn error(String msg) {
//        return error(500, msg);
//    }

    public static CommonReturn error(int code, String msg) {
        CommonReturn r = new CommonReturn();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static CommonReturn error(Map<String, Object> map) {
        CommonReturn r = new CommonReturn();
        r.putAll(map);
        return r;
    }

//    public static CommonReturn ok(String msg) {
//        CommonReturn r = new CommonReturn();
//        r.put("msg", msg);
//        return r;
//    }

    public static CommonReturn success(int code, String msg) {
        CommonReturn r = new CommonReturn();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static CommonReturn success(Map<String, Object> map) {
        CommonReturn r = new CommonReturn();
        r.putAll(map);
        return r;
    }

//    public static CommonReturn ok() {
//        return new CommonReturn();
//    }

    @Override
    public CommonReturn put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
