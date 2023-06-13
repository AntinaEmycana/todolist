package com.example.todolist.dao;

import com.example.todolist.pojo.Do.TaskInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface TaskDao {
    Integer addTask(@Param("title") String title, @Param("content") String content, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    Boolean setUserOwner(@Param("userID") Integer userID, @Param("taskID") Integer taskID);

    Boolean setTeamOwner(@Param("teamID") Integer teamID, @Param("taskID") Integer taskID, @Param("assignee") Integer assignee);

    TaskInfo getTaskInfo(@Param("id") Integer id);

    List<TaskInfo> getUserTask(@Param("userID") Integer userID, @Param("done") Boolean done);

    List<TaskInfo> getTeamTask(@Param("teamID") Integer teamID, @Param("done") Boolean done);

    @MapKey("taskID")
    Map<Integer, Integer> getTeamTaskAssignee(@Param("teamID") Integer teamID);

    Boolean updateTask(@Param("task") TaskInfo task);

    Boolean updateTaskTitle(@Param("title") String title, @Param("id") Integer id);

    Boolean updateTaskContent(@Param("content") String content, @Param("id") Integer id);

    Boolean updateTaskStartDate(@Param("startDate") Date startDate, @Param("id") Integer id);

    Boolean updateTaskEndDate(@Param("endDate") Date endDate, @Param("id") Integer id);

    Boolean updateTaskDone(@Param("done") Boolean done, @Param("id") Integer id);

    Boolean deleteTask(@Param("id") Integer id);

    Boolean deleteUserOwner(@Param("id") Integer id);

    Boolean deleteTeamOwner(@Param("id") Integer id);
}
