package com.deploy.study.dto.user.response;

import com.deploy.study.entity.exception.ErrorResponseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    private String urlPath;

    @Builder
    public ErrorResponse(int status, String message, long timeStamp, String urlPath) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.urlPath = urlPath;
    }

    public ErrorResponseEntity toEntity() {
        return ErrorResponseEntity.builder()
                .status(this.status)
                .message(this.message)
                .timeStamp(this.timeStamp)
                .urlPath(this.urlPath)
                .build();
    }

}
