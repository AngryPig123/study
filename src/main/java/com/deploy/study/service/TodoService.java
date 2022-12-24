package com.deploy.study.service;

import com.deploy.study.dto.ResponseDTO;
import com.deploy.study.dto.user.request.TodoEntityDTO;
import com.deploy.study.entity.todo.TodoEntity;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface TodoService {

    ResponseDTO<TodoEntity> saveTodoEntity(TodoEntityDTO todoEntity);

    ResponseDTO<TodoEntity> getTodoEntity(Long id);

    ResponseDTO<TodoEntity> updateTodoEntity(Long id, TodoEntity.TodoEntityUpdate entityUpdate);

    ResponseDTO<TodoEntity> deleteTodoEntity(Long id);

}
