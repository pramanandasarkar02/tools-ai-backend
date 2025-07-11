package com.toolsai.moderation_service.controller;

import com.toolsai.moderation_service.model.Tool;
import com.toolsai.moderation_service.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tools")
public class ToolController {

    @Autowired
    private ToolRepository toolRepository;

    // Create
    @PostMapping
    public Tool createTool(@RequestBody Tool tool) {
        return toolRepository.save(tool);
    }

    // Read All
    @GetMapping
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<Tool> getToolById(@PathVariable Long id) {
        Optional<Tool> tool = toolRepository.findById(id);
        return tool.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
//    @PutMapping("/{id}")
//    public ResponseEntity<Tool> updateTool(@PathVariable Long id, @RequestBody Tool updatedTool) {
//        Optional<Tool> existingTool = toolRepository.findById(id);
//        if (existingTool.isPresent()) {
//            updatedTool.setId(id);
//            return ResponseEntity.ok(toolRepository.save(updatedTool));
//        }
//        return ResponseEntity.notFound().build();
//    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Long id) {
        if (toolRepository.existsById(id)) {
            toolRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}