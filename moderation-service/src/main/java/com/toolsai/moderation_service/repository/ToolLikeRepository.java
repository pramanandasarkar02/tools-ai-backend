package com.toolsai.moderation_service.repository;



import com.toolsai.moderation_service.model.ToolLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolLikeRepository extends JpaRepository<ToolLike, Long> {
}