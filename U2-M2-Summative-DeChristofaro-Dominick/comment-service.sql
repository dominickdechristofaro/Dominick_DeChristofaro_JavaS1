CREATE SCHEMA IF NOT EXISTS comment;
USE comment;

CREATE TABLE IF NOT EXISTS comment (
	comment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    create_date DATE NOT NULL,
    commenter_name VARCHAR(50) NOT NULL,
    comment VARCHAR(255)
);