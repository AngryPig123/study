package com.deploy.study.service;

import com.deploy.study.exception.CustomBadRequestException;
import com.deploy.study.common.CommonMessage;
import com.deploy.study.dto.ResponseDTO;
import com.deploy.study.dto.user.request.TodoEntityDTO;
import com.deploy.study.entity.todo.TodoEntity;
import com.deploy.study.repository.todo.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.deploy.study.util.ConsoleTextColor.COLOR1;
import static com.deploy.study.util.ConsoleTextColor.RESET;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public ResponseDTO<TodoEntity> saveTodoEntity(TodoEntityDTO entity) {
        saveValidate(entity);
        TodoEntity save = todoRepository.save(entity.toEntity());
        return ResponseDTO.<TodoEntity>builder()
                .status(CommonMessage.successMessage)
                .data(todoRepository.findByUserIdQuery(save.getUserId()))
                .build();
    }

    @Override
    public ResponseDTO<TodoEntity> getTodoEntity(Long id) {
        return ResponseDTO.<TodoEntity>builder()
                .status(CommonMessage.successMessage)
                .data(todoRepository.findById(id).orElse(null))
                .build();
    }

    @Override
    public ResponseDTO<TodoEntity> updateTodoEntity(Long id, TodoEntity.TodoEntityUpdate entityUpdate) {
        TodoEntity todoEntity = todoRepository.findById(id).orElse(null);
        if (todoEntity != null) {
            todoEntity.setTitle(entityUpdate.getTitle());
            todoEntity.setUserId(entityUpdate.getUserId());
            todoEntity.setDone(entityUpdate.isDone());
            todoRepository.save(todoEntity);
        }
        return ResponseDTO.<TodoEntity>builder()
                .status(CommonMessage.successMessage)
                .data(todoRepository.findById(id).orElse(null))
                .build();
    }

    @Override
    public ResponseDTO<TodoEntity> deleteTodoEntity(Long id) {
        TodoEntity todoEntity = this.getTodoEntity(id).getData();
        todoRepository.delete(todoEntity);
        return ResponseDTO.<TodoEntity>builder()
                .status(CommonMessage.successMessage)
                .data(null)
                .build();
    }

    private void saveValidate(TodoEntityDTO entity) {

        if (entity == null) throw new CustomBadRequestException("ET001");
        if (todoRepository.findByUserIdQuery(entity.getUserId()) != null) throw new CustomBadRequestException("ET003");
        if (entity.getUserId() == null) {
            log.warn(COLOR1 + "Unknown user." + RESET);
            throw new CustomBadRequestException("ET002");
        }
    }

}

//  orElseThrow();