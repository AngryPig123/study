package com.deploy.study.contoller;

import com.deploy.study.contoller.todo.TestController;
import com.deploy.study.dto.ResponseDTO;
import com.deploy.study.dto.user.request.TodoEntityDTO;
import com.deploy.study.entity.todo.TodoEntity;
import com.deploy.study.repository.TodoRepository;
import com.deploy.study.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Slf4j
@WebMvcTest(
        value = TestController.class,
        excludeAutoConfiguration = SecurityAutoConfiguration.class
)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    TodoService service;
    @MockBean
    TodoRepository repository;
    ObjectMapper mapper = new ObjectMapper();
    private TodoEntityDTO entityDTO;
    private TodoEntity.TodoEntityUpdate todoEntityUpdate;

    @BeforeEach
    void set_up() {

        entityDTO = TodoEntityDTO.builder()
                .userId("test")
                .title("title")
                .done(true)
                .build();

        todoEntityUpdate = TodoEntity.TodoEntityUpdate.builder()
                .userId("updateUserId")
                .title("updateTitle")
                .done(false)
                .build();

        repository.save(entityDTO.toEntity(entityDTO));
//        log.info(COLOR1 + "postInitTodoEntity = {}" + RESET, postInitTodoEntity);

    }

    //    @PostMapping("add")
    //    public ResponseDTO<TodoEntity> add(@RequestBody TodoEntityDTO todoEntityDTO) {
    //        return todoService.saveTodoEntity(todoEntityDTO);
    //    }
    @Test
    @Order(1)
    void todo_entity_controller_create_test() throws Exception {
        mockMvc.perform(
                        post("/test/add")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(entityDTO))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    //    @GetMapping("{id}")
    //    public ResponseDTO<TodoEntity> getTodoEntity(@PathVariable("id") Long id) {
    //        return todoService.getTodoEntity(id);
    //    }
    @Test
    @Order(2)
    void todo_entity_controller_read_test() throws Exception {
        mockMvc.perform(
                        get("/test/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(entityDTO))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    //    @PatchMapping("{id}")
    //    public ResponseDTO<TodoEntity> updateTodoEntity(
    //            @PathVariable("id") Long id,
    //            @RequestBody TodoEntity.TodoEntityUpdate entityUpdate
    //    ) {
    //        return todoService.updateTodoEntity(id, entityUpdate);
    //    }
    @Test
    @Order(3)
    void todo_entity_controller_update_test() throws Exception {
        Long findId = 1L;

        mockMvc.perform(
                        patch("/test/{id}", findId)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(todoEntityUpdate))
                )
                .andExpect(status().isOk())
                .andDo(print());

        ResponseDTO<TodoEntity> todoEntity = service.getTodoEntity(findId);
        Assertions.assertNull(todoEntity);
    }


    //    @DeleteMapping("{id}")
    //    public ResponseDTO<TodoEntity> deleteTodoEntity(@PathVariable("id") Long id) {
    //        return todoService.deleteTodoEntity(id);
    //    }
    @Test
    @Order(4)
    void todo_entity_controller_delete_test() throws Exception {
        Long findId = 1L;
        TodoEntity afterEntity = service.getTodoEntity(findId).getData();
        Assertions.assertNotNull(afterEntity);
        mockMvc.perform(
                        delete("/test/{id}", findId)
                )
                .andExpect(status().isOk())
                .andDo(print());
        TodoEntity findEntity = service.getTodoEntity(findId).getData();
        Assertions.assertNull(findEntity);
    }

}
