package com.example.todolist.controller;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

@Data
public class TaskRequestBody {
    private Integer id;
    @Size(max = 20, message = "长度过长")
    private String title;
    @Size(max = 100, message = "长度过长")
    private String content;
    private Date startDate;
    @Future(message = "结束时间错误")
    private Date endDate;
    private Boolean done;
    private Integer userID;
    private Integer teamID;
}
