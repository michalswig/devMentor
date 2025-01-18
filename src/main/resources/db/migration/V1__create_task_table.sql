-- V1__create_task_table.sql
CREATE TABLE task (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      completed TINYINT(1) NOT NULL,
                      created_at TIMESTAMP NOT NULL,
                      edited_at TIMESTAMP NULL,
                      deleted_at TIMESTAMP NULL
) ENGINE=InnoDB;