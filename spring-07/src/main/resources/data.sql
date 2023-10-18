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
VALUES ('good', 1)