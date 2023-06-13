package com.example.todolist.pojo.dto;

import com.example.todolist.pojo.Do.TaskInfo;
import lombok.Data;

import java.sql.Date;

@Data
public class TaskDto {
    private Integer id;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private Boolean done;
    private Integer assignee;

    public TaskDto(TaskInfo taskInfo) {
        this.id = taskInfo.getId();
        this.title = taskInfo.getTitle();
        this.content = taskInfo.getContent();
        this.startDate = taskInfo.getStartDate();
        this.endDate = taskInfo.getEndDate();
        this.done = taskInfo.getDone();
        this.assignee = null;
    }

    public TaskDto(TaskInfo taskInfo, Integer assignee) {
        this.id = taskInfo.getId();
        this.title = taskInfo.getTitle();
        this.content = taskInfo.getContent();
        this.startDate = taskInfo.getStartDate();
        this.endDate = taskInfo.getEndDate();
        this.done = taskInfo.getDone();
        this.assignee = assignee;
    }

    public TaskDto(Integer id, String title, String content, Date startDate, Date endDate, Boolean done, Integer assignee) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.done = done;
        this.assignee = assignee;
    }

    public TaskInfo taskInfo(){
        return new TaskInfo(id,title,content,startDate,endDate,done);
    }
}

