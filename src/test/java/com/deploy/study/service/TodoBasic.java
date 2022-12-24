package com.deploy.study.service;

import com.deploy.study.dto.user.request.TodoEntityDTO;
import com.deploy.study.repository.TodoRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ExtendWith(MockitoExtension.class)
public abstract class TodoBasic {

    @PersistenceContext
    public EntityManager em;

    @InjectMocks    //  impl injection
    public TodoServiceImpl service;

    @Mock
    public TodoRepository repository;

    public TodoEntityDTO createObject() {
        return TodoEntityDTO.builder()
                .userId("testId")
                .title("testTitle")
                .done(true)
                .build();
    }

}
