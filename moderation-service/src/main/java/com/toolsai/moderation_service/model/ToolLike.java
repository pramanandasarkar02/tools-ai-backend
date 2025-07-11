package com.toolsai.moderation_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ToolLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;
}