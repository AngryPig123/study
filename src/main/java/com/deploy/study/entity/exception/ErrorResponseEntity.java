package com.deploy.study.entity.exception;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "error_response_entity")
public class ErrorResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int status;
    private String message;
    private long timeStamp;
    private String urlPath;

    @Builder
    public ErrorResponseEntity(int status, String message, long timeStamp, String urlPath) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.urlPath = urlPath;
    }

}
