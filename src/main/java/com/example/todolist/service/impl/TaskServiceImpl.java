package com.example.todolist.service.impl;

import com.example.todolist.dao.TaskDao;
import com.example.todolist.pojo.Do.TaskInfo;
import com.example.todolist.pojo.dto.TaskDto;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public TaskDto addUserTask(String title, String content, Date startDate, Date endDate, Integer user) {
        Integer id = taskDao.addTask(title, content, startDate, endDate);
        taskDao.setUserOwner(user, id);
        return new TaskDto(id, title, content, startDate, endDate, false, null);
    }

    @Override
    public TaskDto addTeamTask(String title, String content, Date startDate, Date endDate, Integer team, Integer assignee) {
        Integer id = taskDao.addTask(title, content, startDate, endDate);
        taskDao.setTeamOwner(team, id, assignee);
        return new TaskDto(id, title, content, startDate, endDate, false, assignee);
    }

    @Override
    public Boolean updateTaskTitle(Integer task, String title) {
        return taskDao.updateTaskTitle(title, task);
    }

    @Override
    public Boolean updateTaskContent(Integer task, String content) {
        return taskDao.updateTaskContent(content, task);
    }

    @Override
    public Boolean updateTaskStartDate(Integer task, Date startDate) {
        return taskDao.updateTaskStartDate(startDate, task);
    }

    @Override
    public Boolean updateTaskEndDate(Integer task, Date endDate) {
        return taskDao.updateTaskEndDate(endDate, task);
    }

    @Override
    public Boolean updateTaskDone(Integer task, Boolean done) {
        return taskDao.updateTaskDone(done, task);
    }

    @Override
    public Boolean updateTask(TaskDto task) {
        return taskDao.updateTask(task.taskInfo());
    }

    @Override
    public Boolean deleteTask(Integer task) {
        taskDao.deleteUserOwner(task);
        taskDao.deleteTeamOwner(task);
        return taskDao.deleteTask(task);
    }

    @Override
    public TaskDto getTask(Integer task) {
        return new TaskDto(taskDao.getTaskInfo(task));
    }

    @Override
    public List<TaskDto> getUserTask(Integer user, Boolean done) {
        List<TaskInfo> taskInfos = taskDao.getUserTask(user, done);
        List<TaskDto> taskDtos = new ArrayList<>();
        for (TaskInfo task : taskInfos) {
            taskDtos.add(new TaskDto(task));
        }
        return taskDtos;
    }

    @Override
    public List<TaskDto> getTeamTask(Integer team, Boolean done) {
        List<TaskInfo> taskInfos = taskDao.getTeamTask(team, done);
        Map<Integer, Integer> teamTaskAssignee = taskDao.getTeamTaskAssignee(team);
        List<TaskDto> taskDtos = new ArrayList<>();
        for (TaskInfo task : taskInfos) {
            taskDtos.add(new TaskDto(task, teamTaskAssignee.get(task.getId())));
        }
        return taskDtos;
    }
}
