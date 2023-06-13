package com.example.todolist.service;

import com.example.todolist.pojo.Do.TaskInfo;
import com.example.todolist.pojo.Do.TeamInfo;
import com.example.todolist.pojo.Do.UserInfo;
import com.example.todolist.pojo.dto.TaskDto;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface TaskService {
    TaskDto addUserTask(String title, String content, Date startDate, Date endDate, Integer user);

    TaskDto addTeamTask(String title, String content, Date startDate, Date endDate, Integer team, Integer assignee);

    Boolean updateTaskTitle(Integer task, String title);

    Boolean updateTaskContent(Integer task, String content);

    Boolean updateTaskStartDate(Integer task, Date startDate);

    Boolean updateTaskEndDate(Integer task, Date endDate);

    Boolean updateTaskDone(Integer task, Boolean done);

    Boolean updateTask(TaskDto task);

    Boolean deleteTask(Integer task);

    TaskDto getTask(Integer task);

    List<TaskDto> getUserTask(Integer user, Boolean done);

    List<TaskDto> getTeamTask(Integer team, Boolean done);
}
