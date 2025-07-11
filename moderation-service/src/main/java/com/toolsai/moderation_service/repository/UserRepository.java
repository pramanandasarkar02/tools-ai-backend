package com.toolsai.moderation_service.repository;



import com.toolsai.moderation_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}