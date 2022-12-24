package com.deploy.study.entity.todo;

import com.deploy.study.dto.user.request.TodoEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "to_do_entity")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String title;
    private boolean done;

    @Builder
    public TodoEntity(String userId, String title, boolean done) {
        this.userId = userId;
        this.title = title;
        this.done = done;
    }

    public TodoEntityDTO toDTO() {
        return TodoEntityDTO.builder()
                .userId(userId)
                .title(title)
                .done(done)
                .build();
    }

    @Data
    @NoArgsConstructor
    public static
    class TodoEntityUpdate {
        private String userId;
        private String title;
        private boolean done;

        @Builder
        public TodoEntityUpdate(String userId, String title, boolean done) {
            this.userId = userId;
            this.title = title;
            this.done = done;
        }
    }

}
