package com.hsk.projectservice.persistent.repository;

import com.hsk.projectservice.persistent.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
