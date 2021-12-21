package com.xk.constant;

import org.omg.CORBA.INTERNAL;

public enum  StateCode {

    LOGIN_SUCCESS(1,"登陆成功"),
    LOGIN_FAIL(2,"账号或密码错误")
    ;

    public Integer code;
    public String message;

    StateCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }



}
