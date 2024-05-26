
-- Insert data for Authors
INSERT INTO authors (public_id, status, created_date, created_by, updated_date, updated_by, name, biography, birthdate, nationality)
VALUES
    ('d74f4a26-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'George Orwell', 'English novelist, essayist, journalist, and critic.', '1903-06-25', 'British'),

    ('d74f4c38-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Jane Austen', 'English novelist known primarily for her six major novels.', '1775-12-16', 'British'),

    ('d74f4d9a-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Mark Twain', 'American writer, humorist, entrepreneur, publisher, and lecturer.', '1835-11-30', 'American'),

    ('d74f4f36-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'J.K. Rowling', 'British author, best known for the Harry Potter series.', '1965-07-31', 'British'),

    ('d74f50d4-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Ernest Hemingway', 'American novelist, short-story writer, and journalist.', '1899-07-21', 'American'),

    ('d74f5262-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Leo Tolstoy', 'Russian writer who is regarded as one of the greatest authors of all time.', '1828-09-09', 'Russian'),

    ('d74f53fa-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Charles Dickens', 'English writer and social critic.', '1812-02-07', 'British'),

    ('d74f5588-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'F. Scott Fitzgerald', 'American novelist, essayist, screenwriter, and short-story writer.', '1896-09-24', 'American'),

    ('d74f570e-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Gabriel Garcia Marquez', 'Colombian novelist, short-story writer, screenwriter, and journalist.', '1927-03-06', 'Colombian'),

    ('d74f589c-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Agatha Christie', 'English writer known for her sixty-six detective novels.', '1890-09-15', 'British'),

    ('d74f5a2a-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'J.R.R. Tolkien', 'English writer, poet, philologist, and academic.', '1892-01-03', 'British'),

    ('d74f5bb8-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Virginia Woolf', 'English writer, considered one of the most important modernist 20th-century authors.', '1882-01-25', 'British'),

    ('d74f5d46-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Harper Lee', 'American novelist widely known for To Kill a Mockingbird.', '1926-04-28', 'American'),

    ('d74f5ed4-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Isaac Asimov', 'American writer and professor of biochemistry, a prolific author and a popular science fiction writer.', '1920-01-02', 'American'),

    ('d74f6062-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Arthur Conan Doyle', 'British writer best known for his detective fiction featuring the character Sherlock Holmes.', '1859-05-22', 'British'),

    ('d74f61f0-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'H.G. Wells', 'English writer, known for his works of science fiction.', '1866-09-21', 'British'),

    ('d74f637e-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Toni Morrison', 'American novelist, essayist, editor, and professor.', '1931-02-18', 'American'),

    ('d74f650c-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Kurt Vonnegut', 'American writer known for his satirical and darkly humorous novels.', '1922-11-11', 'American'),

    ('d74f669a-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'Alice Walker', 'American novelist, short story writer, poet, and social activist.', '1944-02-09', 'American'),

    ('d74f6828-3f6a-11eb-adc1-0242ac120002', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin', 'James Baldwin', 'American novelist, playwright, essayist, poet, and activist.', '1924-08-02', 'American')

    ON CONFLICT (name) DO NOTHING;
