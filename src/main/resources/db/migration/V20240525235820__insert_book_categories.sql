INSERT INTO categories (public_id, name, description, status, created_date, created_by, updated_date, updated_by)
VALUES
    ('fce61f46-c92d-4d02-9c82-d33641a09ff1', 'Fiction', 'Literary fiction, mystery, thriller, science fiction, fantasy, historical fiction, romance, horror, dystopian, and more.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('a76c37c8-f9a4-4462-9530-1b175aef723e', 'Non-Fiction', 'Biography, autobiography, memoir, self-help, health & wellness, history, science, travel, cooking, true crime, and more.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('18f26a08-61cf-4f1c-8d6d-c2b6dd8767c2', 'Children''s Books', 'Picture books, early readers, middle grade, and young adult (YA) books.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('f34c9033-f693-4b25-af4e-4b0d7937c3db', 'Educational', 'Textbooks, reference materials, and workbooks.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('1e74e285-aa0f-45e2-99f0-309c4467d423', 'Graphic Novels', 'Book-length works of fiction or non-fiction illustrated in comic-strip format.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('b5a1dd27-16bc-4d21-9ac7-61d85e372f64', 'Poetry', 'Collections of poems, ranging from classic to contemporary works.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('2fd64ef5-888d-42b3-8dc5-07625b3e19de', 'Drama', 'Plays and scripts meant for performance on stage.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('dcbf622e-2fb0-4f37-a79f-42c9f8f38c56', 'Religion & Spirituality', 'Books covering various religious beliefs and spiritual practices.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('ff27d300-c44a-41a4-bf14-d46d9c9bfa2b', 'Business & Economics', 'Guides on business practices, economic theory, and financial advice.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('a57d2cbf-93e0-465e-bb86-462c7aa6d979', 'Art & Photography', 'Books showcasing visual art and photography techniques.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('9b628f3a-0dd2-44b1-97b0-2673a1c9fe8f', 'Home & Garden', 'Guides on home improvement, gardening, and interior design.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('f33c9ab8-40d4-4b8c-85d3-7692263f361a', 'Crafts & Hobbies', 'Books on various crafts, hobbies, and DIY projects.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('6a3b96d3-c0f0-4a71-bd09-99e3d1bfe9e1', 'Sports & Outdoors', 'Books on sports techniques, outdoor adventures, and recreational activities.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin'),

    ('b99ff6e1-dc1d-47b2-bdc7-930038a7039a', 'Computers & Technology', 'Guides on software, hardware, and emerging technologies.', 'AVAILABLE', CURRENT_DATE, 'admin', CURRENT_DATE, 'admin')
    ON CONFLICT ( name) DO NOTHING;
