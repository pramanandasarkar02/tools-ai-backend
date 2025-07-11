package com.toolsai.moderation_service.repository;

import com.toolsai.moderation_service.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Long> {
}