package com.deploy.study.repository.exception;

import com.deploy.study.entity.exception.ErrorResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorResponseRepository extends JpaRepository<ErrorResponseEntity, Long> {

}
