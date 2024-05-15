package com.heima.model.common.dtos;

import com.alibaba.fastjson.JSON;
import com.heima.model.common.enums.AppHttpCodeEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用的结果返回类
 *
 * @author Kang Yong
 * @date 2024/4/19
 * @since 1.0.0
 */
public class R<T> implements Serializable {

    private String host;

    private Integer code;

    private String msg;

    private T data;

    public R() {
        this.code = 200;
    }

    public R(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static R errorResult(int code, String msg) {
        R result = new R();
        return result.error(code, msg);
    }

    public static R okResult(int code, String msg) {
        R result = new R();
        return result.ok(code, null, msg);
    }

    public static R okResult(Object data) {
        R result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getDesc());
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static R okResult() {
        R result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getDesc());
        return result;
    }

    public static R errorResult(AppHttpCodeEnum enums) {
        return setAppHttpCodeEnum(enums, enums.getDesc());
    }

    public static R errorResult(AppHttpCodeEnum enums, String msg) {
        return setAppHttpCodeEnum(enums, msg);
    }

    public static R setAppHttpCodeEnum(AppHttpCodeEnum enums) {
        return okResult(enums.getCode(), enums.getDesc());
    }

    private static R setAppHttpCodeEnum(AppHttpCodeEnum enums, String msg) {
        return okResult(enums.getCode(), msg);
    }

    public R<?> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public R<?> ok() {
        this.code = 200;
        return this;
    }

    public R<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public R<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return msg;
    }

    public void setErrorMessage(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


    public static void main(String[] args) {
        //前置
        /*AppHttpCodeEnum success = AppHttpCodeEnum.SUCCESS;
        System.out.println(success.getCode());
        System.out.println(success.getErrorMessage());*/

        //查询一个对象
        /*Map map = new HashMap();
        map.put("name","zhangsan");
        map.put("age",18);
        R result = R.okResult(map);
        System.out.println(JSON.toJSONString(result));*/


        //新增，修改，删除  在项目中统一返回成功即可
        /*R result = R.okResult(AppHttpCodeEnum.SUCCESS);
        System.out.println(JSON.toJSONString(result));*/


        //根据不用的业务返回不同的提示信息  比如：当前操作需要登录、参数错误
        /*R result = R.errorResult(AppHttpCodeEnum.NEED_LOGIN,"自定义提示信息");
        System.out.println(JSON.toJSONString(result));*/

        //查询分页信息
        PageResponseResult responseResult = new PageResponseResult(1, 5, 50);
        List list = new ArrayList();
        list.add("itcast");
        list.add("itheima");
        responseResult.setData(list);
        System.out.println(JSON.toJSONString(responseResult));

    }

}
