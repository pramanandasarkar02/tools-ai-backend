CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tool (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    launch_date DATE
);

CREATE TABLE IF NOT EXISTS tool_comment (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    tool_id BIGINT REFERENCES tool(id),
    comments TEXT,
    upvote INTEGER,
    downvote INTEGER
);

CREATE TABLE IF NOT EXISTS tool_like (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    tool_id BIGINT REFERENCES tool(id)
);