package com.deploy.study.repository;

import com.deploy.study.entity.todo.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    @Query("select t from TodoEntity t where t.userId = ?1")
    TodoEntity findByUserIdQuery(String userId);

//    @Modifying(clearAutomatically = true)
//    @Query("update TodoEntity t set t.userId =: userId,t.title =: title,t.done =: done where t.id=:id")
//    int todoEntityUpdate(Long id, TodoEntity.TodoEntityUpdate todoEntityUpdate);

}
