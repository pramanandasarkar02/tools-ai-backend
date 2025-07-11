package com.toolsai.moderation_service.repository;



import com.toolsai.moderation_service.model.ToolComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolCommentRepository extends JpaRepository<ToolComment, Long> {
}