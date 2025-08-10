import express from 'express';
import axios from 'axios';
import dotenv from 'dotenv';
import fs from 'fs';
const tools = JSON.parse(fs.readFileSync('./tools.json', 'utf-8'));

dotenv.config();

const app = express();
const port = process.env.PORT || 3000;

// Helper function to print tools (fixed syntax)
const printTools = () => {
    console.log("Available Tools:");
    tools.tools.forEach(tool => {
        console.log(`- ${tool.name} (by ${tool.organization})`);
    });
};

// Middleware
app.use(express.json());

// Routes
app.get('/api/tools', (req, res) => {
    res.json({
        success: true,
        count: tools.tools.length,
        tools: tools.tools
    });
});

app.get('/api/tools/:name', (req, res) => {
    const toolName = req.params.name.toLowerCase();
    const tool = tools.tools.find(t => 
        t.name.toLowerCase().includes(toolName)
    );

    if (!tool) {
        return res.status(404).json({
            success: false,
            message: "Tool not found"
        });
    }

    res.json({
        success: true,
        tool
    });
});

// Error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({
        success: false,
        message: "Internal server error"
    });
});

// Start server
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
    printTools(); // Print available tools on startup
});