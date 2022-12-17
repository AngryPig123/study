package com.deploy.study.entity.todo;

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

    public TodoEntity(String userId, String title, boolean done) {
        this.userId = userId;
        this.title = title;
        this.done = done;
    }

}
