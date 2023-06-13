package com.example.todolist.controller;

import com.example.todolist.pojo.dto.TaskDto;
import com.example.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addUserTask")
    public TaskDto addUserTask(@Valid @RequestBody TaskRequestBody taskRequestBody) {
        return taskService.addUserTask(taskRequestBody.getTitle(), taskRequestBody.getContent(),
                taskRequestBody.getStartDate(), taskRequestBody.getEndDate(),
                taskRequestBody.getUserID());
    }

    @PostMapping("/addTeamTask")
    public TaskDto addTeamTask(@Valid @RequestBody TaskRequestBody taskRequestBody) {
        return taskService.addTeamTask(taskRequestBody.getTitle(), taskRequestBody.getContent(),
                taskRequestBody.getStartDate(), taskRequestBody.getEndDate(),
                taskRequestBody.getTeamID(), taskRequestBody.getUserID());
    }

    @PostMapping("/updateTaskTitle")
    public Boolean updateTaskTitle(@RequestParam("id") Integer id, @RequestParam("title") String title) {
        return taskService.updateTaskTitle(id, title);
    }

    @PostMapping("/updateTaskContent")
    public Boolean updateTaskContent(@RequestParam("id") Integer id, @RequestParam("content") String content) {
        return taskService.updateTaskContent(id, content);
    }

    @PostMapping("/updateTaskStartDate")
    public Boolean updateTaskStartDate(@RequestParam("id") Integer id, @RequestParam("startDate") Date startDate) {
        return taskService.updateTaskStartDate(id, startDate);
    }

    @PostMapping("/updateTaskEndDate")
    public Boolean updateTaskEndDate(@RequestParam("id") Integer id, @RequestParam("endDate") Date endDate) {
        return taskService.updateTaskEndDate(id, endDate);
    }

    @PostMapping("/updateTaskDone")
    public Boolean updateTaskDone(@RequestParam("id") Integer id, @RequestParam("done") Boolean done) {
        return taskService.updateTaskDone(id, done);
    }

    @PostMapping("/updateTask")
    public Boolean updateTask(@Valid @RequestBody TaskRequestBody taskRequestBody) {
        return taskService.updateTask(new TaskDto(taskRequestBody.getId(),
                taskRequestBody.getTitle(), taskRequestBody.getContent(),
                taskRequestBody.getStartDate(), taskRequestBody.getEndDate(),
                taskRequestBody.getDone(), null));
    }

    @PostMapping("/deleteTask")
    public Boolean deleteTask(@RequestParam("id") Integer id) {
        return taskService.deleteTask(id);
    }

    @PostMapping("/getTask")
    public TaskDto getTask(@RequestParam("id") Integer id) {
        return taskService.getTask(id);
    }

    @PostMapping("/getUserTask")
    public List<TaskDto> getUserTask(@RequestParam("id") Integer id,
                                     @RequestParam(value = "done", required = false) Boolean done) {
        return taskService.getUserTask(id, done);
    }

    @PostMapping("/getTeamTask")
    public List<TaskDto> getTeamTask(@RequestParam("id") Integer id,
                                     @RequestParam(value = "done", required = false) Boolean done) {
        return taskService.getTeamTask(id, done);
    }
}
