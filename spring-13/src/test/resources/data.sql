INSERT INTO genres (name)
VALUES ('Unknown');

INSERT INTO genres (name)
VALUES ('Horror');

INSERT INTO genres (name)
VALUES ('Fantasy');

INSERT INTO authors (name)
VALUES ('Unknown');

INSERT INTO authors (name)
VALUES ('Bram Stoker');

INSERT INTO authors (name)
VALUES ('Stephen King');

INSERT INTO books (name, author_id, genre_id)
VALUES ('Dracula', 2, 3);

INSERT INTO comments (text, book_id)
VALUES ('good', 1);

INSERT INTO users (username, password, email)
VALUES ('admintest', '$2a$12$NR1rcA6S0aZn0STOe527I.ZCGDi2G.A58fpupSXUxa4u.tssSNWLq', 'admin@example.com');

INSERT INTO users (username, password, email)
VALUES ('usertest', '$2a$12$NR1rcA6S0aZn0STOe527I.ZCGDi2G.A58fpupSXUxa4u.tssSNWLq', 'user@example.com');

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2);