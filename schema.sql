-- Database schema for Academic Progress Tracker

CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE progress (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT REFERENCES users(id),
  subject VARCHAR(100),
  score INT,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
