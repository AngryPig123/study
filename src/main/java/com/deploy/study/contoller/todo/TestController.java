package com.deploy.study.contoller.todo;

import com.deploy.study.dto.ResponseDTO;
import com.deploy.study.dto.user.request.TodoEntityDTO;
import com.deploy.study.entity.todo.TodoEntity;
import com.deploy.study.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final TodoService todoService;

    @PostMapping("add")
    public ResponseDTO<TodoEntity> add(@RequestBody TodoEntityDTO todoEntityDTO) {
        return todoService.saveTodoEntity(todoEntityDTO);
    }

    @GetMapping("{id}")
    public ResponseDTO<TodoEntity> getTodoEntity(@PathVariable("id") Long id) {
        return todoService.getTodoEntity(id);
    }

    @PatchMapping("{id}")
    public ResponseDTO<TodoEntity> updateTodoEntity(
            @PathVariable("id") Long id,
            @RequestBody TodoEntity.TodoEntityUpdate entityUpdate
    ) {
        return todoService.updateTodoEntity(id, entityUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseDTO<TodoEntity> deleteTodoEntity(@PathVariable("id") Long id) {
        return todoService.deleteTodoEntity(id);
    }

}
