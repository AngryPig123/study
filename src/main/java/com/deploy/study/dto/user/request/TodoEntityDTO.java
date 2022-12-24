package com.deploy.study.dto.user.request;

import com.deploy.study.entity.todo.TodoEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class TodoEntityDTO {
    private String userId;
    private String title;
    private boolean done;

    public TodoEntityDTO() {
    }

    @Builder
    public TodoEntityDTO(String userId, String title, boolean done) {
        this.userId = userId;
        this.title = title;
        this.done = done;
    }

    public TodoEntity toEntity(final TodoEntityDTO dto) {
        return TodoEntity.builder()
                .userId(dto.getUserId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }

}
