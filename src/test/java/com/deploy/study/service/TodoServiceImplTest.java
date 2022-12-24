package com.deploy.study.service;

import com.deploy.study.dto.user.request.TodoEntityDTO;
import org.junit.jupiter.api.*;
import org.springframework.test.annotation.Rollback;

@Rollback(false)
@TestMethodOrder(MethodOrderer.Random.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TodoServiceImplTest extends TodoBasic {

    private TodoEntityDTO todoEntityDTO;

}