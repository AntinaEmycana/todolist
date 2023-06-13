package com.example.todolist.pojo.Do;

import lombok.Data;

import java.sql.Date;

@Data
public class TaskInfo {
    private Integer id;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private Boolean done;

    public TaskInfo(Integer id, String title, String content, Date startDate, Date endDate, Boolean done) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.done = done;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", done=" + done +
                '}';
    }
}
