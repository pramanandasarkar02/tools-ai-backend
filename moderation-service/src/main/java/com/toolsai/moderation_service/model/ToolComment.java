package com.toolsai.moderation_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ToolComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    private String comments;
    private Integer upvote;
    private Integer downvote;
}