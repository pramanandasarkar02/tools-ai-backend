-- Insert Users
INSERT INTO users (name, email, password) VALUES
('John Doe', 'john@example.com', 'password123'),
('Jane Smith', 'jane@example.com', 'password456');

-- Insert Tools
INSERT INTO tool (title, description, launch_date) VALUES
('Tool A', 'A powerful tool for automation', '2025-01-01'),
('Tool B', 'A tool for data analysis', '2025-02-15');

-- Insert ToolComments
INSERT INTO tool_comment (user_id, tool_id, comments, upvote, downvote) VALUES
(1, 1, 'Great tool for automation!', 10, 2),
(2, 1, 'Very useful, but needs better UI.', 5, 3),
(1, 2, 'Amazing for data analysis.', 8, 0);

-- Insert ToolLikes
INSERT INTO tool_like (user_id, tool_id) VALUES
(1, 1),
(2, 1),
(1, 2);