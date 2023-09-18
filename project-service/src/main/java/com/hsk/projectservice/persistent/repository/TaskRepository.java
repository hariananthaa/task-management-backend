package com.hsk.projectservice.persistent.repository;

import com.hsk.projectservice.persistent.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByProject_Key(String projectKey);
}
