create table users (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    profile_picture_url VARCHAR(200) NULL,
    updated_at datetime NOT NULL,
    created_at datetime NOT NULL
);

create table boards (
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(500) NOT NULL,
    content VARCHAR(4000) NOT NULL,
    updated_at datetime NOT NULL,
    created_at datetime NOT NULL
);