-- Create Author Table if not exists
CREATE TABLE IF NOT EXISTS authors
(
    id           BIGSERIAL PRIMARY KEY,
    public_id       uuid NOT NULL UNIQUE,
    status       VARCHAR(255),
    created_date DATE,
    created_by   VARCHAR(255) NOT NULL,
    updated_date DATE,
    updated_by   VARCHAR(255),
    name         VARCHAR(255) NOT NULL,
    biography    TEXT,
    birthdate    DATE,
    nationality  VARCHAR(100),
    CONSTRAINT idx_author_name UNIQUE (name)
);

-- Create Publisher Table if not exists
CREATE TABLE IF NOT EXISTS publishers
(
    id             BIGSERIAL PRIMARY KEY,
    public_id       uuid NOT NULL UNIQUE,
    publisher_status VARCHAR(50),
    created_date   DATE,
    created_by     VARCHAR(255) NOT NULL,
    updated_date   DATE,
    updated_by     VARCHAR(255),
    name           VARCHAR(255) NOT NULL UNIQUE,
    address        VARCHAR(255),
    contact_number VARCHAR(120),
    CONSTRAINT idx_publisher_name UNIQUE (name)
);

-- Create Category Table if not exists
CREATE TABLE IF NOT EXISTS categories
(
    id           BIGSERIAL PRIMARY KEY,
    public_id       uuid NOT NULL UNIQUE,
    status       VARCHAR(255),
    created_date DATE,
    created_by   VARCHAR(255) NOT NULL,
    updated_date DATE,
    updated_by   VARCHAR(255),
    name         VARCHAR(255) NOT NULL UNIQUE,
    description  TEXT,
    CONSTRAINT idx_category_name UNIQUE (name)
);

-- Create Book Table if not exists
CREATE TABLE IF NOT EXISTS books
(
    id                  BIGSERIAL PRIMARY KEY,
    public_id       uuid NOT NULL,
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
    publisher_id        BIGINT,
    category_id         BIGINT,
    CONSTRAINT idx_book_title UNIQUE (title),
    CONSTRAINT idx_book_isbn UNIQUE (isbn),
    CONSTRAINT fk_book_publisher_id FOREIGN KEY (publisher_id) REFERENCES publishers (id),
    CONSTRAINT fk_book_category_id FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS book_authors
(
    book_id   BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (author_id) REFERENCES authors (id)
);

-- Create Store User Table if not exists
CREATE TABLE IF NOT EXISTS store_users
(
    id                BIGSERIAL PRIMARY KEY,
    public_id       uuid NOT NULL,
    status            VARCHAR(50),
    created_date      DATE,
    created_by        VARCHAR(255) NOT NULL,
    updated_date      DATE,
    updated_by        VARCHAR(255),
    first_name              VARCHAR(255) NOT NULL,
    last_name              VARCHAR(255) NOT NULL,
    email             VARCHAR(255) NOT NULL UNIQUE,
    address           VARCHAR(255),
    phone_number             VARCHAR(20),
    password             VARCHAR(120),
    registration_date DATE
);
-- Create FavouriteBookData Table if not exists
CREATE TABLE IF NOT EXISTS user_favourite_books
(
    id BIGSERIAL PRIMARY KEY,
    public_id uuid NOT NULL,
    created_date DATE,
    created_by VARCHAR(255) NOT NULL,
    updated_date DATE,
    updated_by VARCHAR(255),
    user_id BIGINT,
    CONSTRAINT fk_favourite_book_user_id FOREIGN KEY (user_id) REFERENCES store_users (id)
);

-- Create Many-to-Many Relationship Table if not exists
CREATE TABLE IF NOT EXISTS favourite_books
(
    favourite_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    PRIMARY KEY (favourite_id, book_id),
    FOREIGN KEY (favourite_id) REFERENCES user_favourite_books (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

-- Create Order Table if not exists
CREATE TABLE IF NOT EXISTS orders
(
    id BIGSERIAL PRIMARY KEY,
    public_id       uuid NOT NULL,
    status VARCHAR(50),
    total_amount DECIMAL(10, 2) NOT NULL,
    created_date DATE,
    created_by VARCHAR(255) NOT NULL,
    updated_date DATE,
    updated_by VARCHAR(255),
    order_date DATE NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES store_users(id)
);

-- Create Book_Order Table if not exists
CREATE TABLE IF NOT EXISTS book_order
(
    book_id  BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, order_id),
    CONSTRAINT fk_book_order_book_id FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE,
    CONSTRAINT fk_book_order_order_id FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE
);

-- Create Review Table if not exists
CREATE TABLE IF NOT EXISTS reviews
(
    id BIGSERIAL PRIMARY KEY,
    public_id UUID,
    rating INT,
    comment TEXT,
    review_date DATE,
    created_date DATE,
    created_by VARCHAR(255) NOT NULL,
    updated_date DATE,
    updated_by VARCHAR(255),
    book_id BIGINT,
    user_id BIGINT,
    CONSTRAINT fk_review_book_id FOREIGN KEY (book_id) REFERENCES books (id),
    CONSTRAINT fk_review_user_id FOREIGN KEY (user_id) REFERENCES store_users (id)
);
