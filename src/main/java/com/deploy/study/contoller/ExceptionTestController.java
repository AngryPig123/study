package com.deploy.study.contoller;

import com.deploy.study.exception.CustomBadRequestException;
import com.deploy.study.exception.CustomNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTestController {

    @GetMapping("/bad-request")
    public String test1() {
        throw new CustomBadRequestException("B001");
    }

    @GetMapping("/not-found")
    public String test2() {
        throw new CustomNotFoundException("B002");
    }


}
