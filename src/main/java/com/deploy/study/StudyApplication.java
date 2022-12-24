package com.deploy.study;

import com.deploy.study.entity.todo.TodoEntity;
import com.deploy.study.repository.TodoRepository;
import com.deploy.study.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.annotation.PostConstruct;

import static com.deploy.study.util.ConsoleTextColor.COLOR1;
import static com.deploy.study.util.ConsoleTextColor.RESET;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    private final TodoRepository repository;

    @PostConstruct
    public void init() {
        TodoEntity todoEntity = TodoEntity.builder()
                .userId("userId")
                .title("title")
                .done(true)
                .build();
        TodoEntity postInitTodoEntity = repository.save(todoEntity);
        log.info(COLOR1 + "postInitTodoEntity = {}" + RESET, postInitTodoEntity);
    }

}
