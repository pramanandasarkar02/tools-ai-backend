package com.toolsai.moderation_service.controller;

import com.toolsai.moderation_service.model.ToolComment;
import com.toolsai.moderation_service.repository.ToolCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tool-comments")
public class ToolCommentController {

    @Autowired
    private ToolCommentRepository toolCommentRepository;

    // Create a new ToolComment
    @PostMapping
    public ToolComment createToolComment(@RequestBody ToolComment toolComment) {
        return toolCommentRepository.save(toolComment);
    }

    // Read all ToolComments
    @GetMapping
    public List<ToolComment> getAllToolComments() {
        return toolCommentRepository.findAll();
    }

    // Read a single ToolComment by ID
    @GetMapping("/{id}")
    public ResponseEntity<ToolComment> getToolCommentById(@PathVariable Long id) {
        Optional<ToolComment> toolComment = toolCommentRepository.findById(id);
        return toolComment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a ToolComment
//    @PutMapping("/{id}")
//    public ResponseEntity<ToolComment> updateToolComment(@PathVariable Long id, @RequestBody ToolComment updatedToolComment) {
//        Optional<ToolComment> existingToolComment = toolCommentRepository.findById(id);
//        if (existingToolComment.isPresent()) {
//            updatedToolComment.setId(id);
//            return ResponseEntity.ok(toolCommentRepository.save(updatedToolComment));
//        }
//        return ResponseEntity.notFound().build();
//    }

    // Delete a ToolComment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToolComment(@PathVariable Long id) {
        if (toolCommentRepository.existsById(id)) {
            toolCommentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}