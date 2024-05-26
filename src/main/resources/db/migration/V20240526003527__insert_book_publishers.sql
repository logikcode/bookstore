INSERT INTO publishers (public_id, publisher_status, created_date, created_by, updated_date, updated_by, name, address,
                        contact_number)
VALUES ('c3195d5e-7ff7-4d8f-8bf6-2efb9303c1e3', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Penguin Random House', '123 Main St, New York, NY', 'contact@penguinrandomhouse.com'),

       ('2df18b76-28c1-4d26-8654-394db8c24de0', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'HarperCollins Publishers', '456 Broadway, San Francisco, CA', 'contact@harpercollins.com'),

       ('aa9b6b3f-18f5-44c6-923e-58c33b81bc25', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Simon & Schuster', '789 Park Ave, Los Angeles, CA', 'contact@simonandschuster.com'),

       ('3a598882-fd52-4ef7-b236-2cf4a01c10ff', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Hachette Book Group', '101 Market St, Chicago, IL', 'contact@hachettebookgroup.com'),

       ('152ab925-9f52-491f-bd15-d462d3a9188c', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Macmillan Publishers', '555 Elm St, Boston, MA', 'contact@macmillanpublishers.com'),

       ('6dd94c8e-129a-4b48-a2b7-63e7016b8217', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Scholastic Corporation', '321 Oak St, Seattle, WA', 'contact@scholastic.com'),

       ('80e69f50-babb-4a60-b8d0-6efc191a8de5', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Bloomsbury Publishing', '987 Pine St, Denver, CO', 'contact@bloomsbury.com'),

       ('b1b41aa1-79f2-493e-b1ee-5c31eb94660d', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Houghton Mifflin Harcourt', '555 Cedar St, Miami, FL', 'contact@hmhco.com'),

       ('e401d26e-7b6f-45d5-9b71-d36f8f9dc497', 'ACTIVE',  CURRENT_TIMESTAMP,'admin', CURRENT_TIMESTAMP, 'admin',
        'Oxford University Press', '789 Walnut St, Philadelphia, PA', 'contact@oup.com'),

       ('9579750c-10ec-4666-8596-79f8c90a1cbb', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Cambridge University Press', '888 Maple St, Houston, TX', 'contact@cambridge.org'),

       ('8ae6e99f-c5fb-4a6e-b8b3-8c7d6743e8f9', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Pearson', '444 Oak St, Austin, TX', 'contact@pearson.com'),

       ('ab3357b5-9dfb-48ee-8370-468e5278933a', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Houghton Mifflin', '333 Elm St, Portland, OR', 'contact@hmhbooks.com'),

       ('59b28a84-5206-4f0f-9a1a-d1871d4de11e', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Wiley', '777 Maple St, Nashville, TN', 'contact@wiley.com'),

       ('0d19ff86-89dc-40d1-b6dc-7a2eaeed8dc3', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Harvard University Press', '222 Pine St, Atlanta, GA', 'contact@harvard.edu'),

       ('5728a5a1-c1e3-4154-bdb9-7aa7e91c0af0', 'ACTIVE', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin',
        'Princeton University Press', '999 Cedar St, Raleigh, NC',
        'contact@princeton.edu') ON CONFLICT (name) DO NOTHING;
