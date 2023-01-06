package com.deploy.study.contoller;

import com.deploy.study.advice.CustomBadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTestController {

    @GetMapping("/exception")
    public String test() {
        throw new CustomBadRequestException("B001");
    }


}
