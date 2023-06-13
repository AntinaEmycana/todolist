package com.example.todolist.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class ControllerResponse implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    public static ControllerResponse succ(Object data) {
        ControllerResponse m = new ControllerResponse();
        m.setCode(0);
        m.setData(data);
        m.setMsg("操作成功");
        return m;
    }
    public static ControllerResponse succ(String mess, Object data) {
        ControllerResponse m = new ControllerResponse();
        m.setCode(0);
        m.setData(data);
        m.setMsg(mess);
        return m;
    }
    public static ControllerResponse fail(String mess) {
        ControllerResponse m = new ControllerResponse();
        m.setCode(-1);
        m.setData(null);
        m.setMsg(mess);
        return m;
    }
    public static ControllerResponse fail(String mess, Object data) {
        ControllerResponse m = new ControllerResponse();
        m.setData(data);
        m.setMsg(mess);
        return m;
    }
}
