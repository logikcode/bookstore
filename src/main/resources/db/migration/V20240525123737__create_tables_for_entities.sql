-- Create Author Table if not exists
CREATE TABLE IF NOT EXISTS authors
(
    id          BIGSERIAL PRIMARY KEY,
    status      VARCHAR(255),
    created_date DATE,
    created_by  VARCHAR(255) NOT NULL,
    updated_date DATE,
    updated_by  VARCHAR(255),
    name        VARCHAR(255) NOT NULL,
    biography   TEXT,
    birthdate   DATE,
    nationality VARCHAR(100),
    CONSTRAINT idx_author_name UNIQUE (name)
);

-- Create Publisher Table if not exists
CREATE TABLE IF NOT EXISTS publishers
(
    id             BIGSERIAL PRIMARY KEY,
    status         VARCHAR(255),
    created_date   DATE,
    created_by     VARCHAR(255) NOT NULL,
    updated_date   DATE,
    updated_by     VARCHAR(255),
    name           VARCHAR(255) NOT NULL,
    address        VARCHAR(255),
    contact_number VARCHAR(20),
    CONSTRAINT idx_publisher_name UNIQUE (name)
);

-- Create Category Table if not exists
CREATE TABLE IF NOT EXISTS categories
(
    id          BIGSERIAL PRIMARY KEY,
    status      VARCHAR(255),
    created_date DATE,
    created_by   VARCHAR(255) NOT NULL,
    updated_date DATE,
    updated_by   VARCHAR(255),
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    CONSTRAINT idx_category_name UNIQUE (name)
);

-- Create Book Table if not exists
CREATE TABLE IF NOT EXISTS books
(
    id                  BIGSERIAL PRIMARY KEY,
    status              VARCHAR(255),
    created_date        DATE,
    created_by          VARCHAR(255) NOT NULL,
    updated_date        DATE,
    updated_by          VARCHAR(255),
    title               VARCHAR(255) NOT NULL,
    isbn                VARCHAR(13)  NOT NULL,
    price               DECIMAL(10, 2),
    publication_date    DATE,
    description         TEXT,
    availability_status VARCHAR(50),
    author_id           BIGSERIAL,
    publisher_id        BIGSERIAL,
    category_id         BIGSERIAL,
    CONSTRAINT idx_book_title UNIQUE (title),
    CONSTRAINT idx_book_isbn UNIQUE (isbn),
    CONSTRAINT fk_book_author_id FOREIGN KEY (author_id) REFERENCES authors (id),
    CONSTRAINT fk_book_publisher_id FOREIGN KEY (publisher_id) REFERENCES publishers (id),
    CONSTRAINT fk_book_category_id FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS book_authors
(
    book_id   BIGSERIAL NOT NULL,
    author_id BIGSERIAL NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (author_id) REFERENCES authors (id)
);

-- Create Store User Table if not exists
CREATE TABLE IF NOT EXISTS store_users
(
    id                BIGSERIAL PRIMARY KEY,
    status            VARCHAR(255),
    created_date      DATE,
    created_by        VARCHAR(255) NOT NULL,
    updated_date      DATE,
    updated_by        VARCHAR(255),
    name              VARCHAR(255) NOT NULL,
    email             VARCHAR(255) NOT NULL UNIQUE,
    address           VARCHAR(255),
    phone             VARCHAR(20),
    registration_date DATE
);

-- Create FavouriteBookData Table if not exists
CREATE TABLE IF NOT EXISTS favourite_books
(
    id                  BIGSERIAL PRIMARY KEY,
    status              VARCHAR(255),
    created_date        DATE,
    created_by          VARCHAR(255) NOT NULL,
    updated_date        DATE,
    updated_by          VARCHAR(255),
    user_id             BIGINT,
    CONSTRAINT fk_favourite_book_user_id FOREIGN KEY (user_id) REFERENCES store_users (id)
);

-- Create Many-to-Many Relationship Table if not exists
CREATE TABLE IF NOT EXISTS user_favourite_books
(
    favourite_id BIGINT NOT NULL,
    book_id      BIGINT NOT NULL,
    PRIMARY KEY (favourite_id, book_id),
    FOREIGN KEY (favourite_id) REFERENCES favourite_books (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

