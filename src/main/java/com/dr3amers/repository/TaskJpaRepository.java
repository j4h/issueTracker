package com.dr3amers.repository;

import com.dr3amers.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<Task, Integer> {
}
