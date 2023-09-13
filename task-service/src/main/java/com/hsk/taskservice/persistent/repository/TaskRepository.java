package com.hsk.taskservice.persistent.repository;

import com.hsk.taskservice.persistent.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
