-- V2__insert_initial_data.sql
INSERT INTO task (title, description, completed, created_at, edited_at, deleted_at)
VALUES
    ('Task 1', 'Description for Task 1', 0, NOW(), NULL, NULL),
    ('Task 2', 'Description for Task 2', 0, NOW(), NULL, NULL),
    ('Task 3', 'Description for Task 3', 0, NOW(), NULL, NULL),
    ('Task 4', 'Description for Task 4', 0, NOW(), NULL, NULL),
    ('Task 5', 'Description for Task 5', 0, NOW(), NULL, NULL);