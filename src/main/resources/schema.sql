-- src/main/resources/schema.sql

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ticket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    from_location VARCHAR(255),
    to_location VARCHAR(255),
    price DOUBLE,
    user_id BIGINT,
    seat_section VARCHAR(255),
    CONSTRAINT fk_user
      FOREIGN KEY (user_id)
      REFERENCES users(id)
);