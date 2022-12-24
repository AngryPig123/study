package com.deploy.study;

import com.deploy.study.entity.todo.TodoEntity;
import com.deploy.study.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;

import static com.deploy.study.util.ConsoleTextColor.COLOR1;
import static com.deploy.study.util.ConsoleTextColor.RESET;


@SpringBootTest
class StudyApplicationTests {

    @Test
    void contextLoads() {
    }

}
