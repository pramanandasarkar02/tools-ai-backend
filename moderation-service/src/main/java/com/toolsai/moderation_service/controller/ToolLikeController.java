package com.toolsai.moderation_service.controller;


import com.toolsai.moderation_service.model.ToolLike;
import com.toolsai.moderation_service.repository.ToolLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tool-likes")
public class ToolLikeController {

    @Autowired
    private ToolLikeRepository toolLikeRepository;

    // Create a new ToolLike
    @PostMapping
    public ToolLike createToolLike(@RequestBody ToolLike toolLike) {
        return toolLikeRepository.save(toolLike);
    }

    // Read all ToolLikes
    @GetMapping
    public List<ToolLike> getAllToolLikes() {
        return toolLikeRepository.findAll();
    }

    // Read a single ToolLike by ID
    @GetMapping("/{id}")
    public ResponseEntity<ToolLike> getToolLikeById(@PathVariable Long id) {
        Optional<ToolLike> toolLike = toolLikeRepository.findById(id);
        return toolLike.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a ToolLike
//    @PutMapping("/{id}")
//    public ResponseEntity<ToolLike> updateToolLike(@PathVariable Long id, @RequestBody ToolLike updatedToolLike) {
//        Optional<ToolLike> existingToolLike = toolLikeRepository.findById(id);
//        if (existingToolLike.isPresent()) {
//            updatedToolLike.setId(id);
//            return ResponseEntity.ok(toolLikeRepository.save(updatedToolLike));
//        }
//        return ResponseEntity.notFound().build();
//    }

    // Delete a ToolLike
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToolLike(@PathVariable Long id) {
        if (toolLikeRepository.existsById(id)) {
            toolLikeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
