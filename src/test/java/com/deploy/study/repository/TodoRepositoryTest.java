package com.deploy.study.repository;

import com.deploy.study.entity.todo.TodoEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoRepositoryTest {

    @Autowired
    TodoRepository repository;

    private TodoEntity todoEntity;

    private TodoEntity findEntity;

    @BeforeEach
    void set_up() {
        todoEntity = new TodoEntity("test_entity", "todo_entity", false);

        //  save
        TodoEntity saveEntity = repository.save(todoEntity);
        Assertions.assertNotNull(saveEntity);

        //  find entity
        findEntity = repository.findById(1L).orElse(null);
        Assertions.assertNotNull(findEntity);

    }

    @Test
    @Order(1)
    void todo_todo_repository_update_test() {
        todoEntity.setTitle("modified");
        Assertions.assertEquals(repository.findById(1L).orElse(null).getTitle(), "modified");
    }

    @Test
    @Order(2)
    void todo_todo_repository_delete_test() {
        repository.delete(findEntity);
        Assertions.assertNull(repository.findById(1L).orElse(null));
    }

}
