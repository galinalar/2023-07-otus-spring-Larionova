INSERT INTO genres (name)
VALUES ('Unknown');

INSERT INTO genres (name)
VALUES ('Horr');

INSERT INTO genres (name)
VALUES ('Fan');

INSERT INTO authors (name)
VALUES ('Unknown');

INSERT INTO authors (name)
VALUES ('Stoker');

INSERT INTO authors (name)
VALUES ('King');

INSERT INTO books (name, author_id, genre_id)
VALUES ('Dracula', 1, 2);

INSERT INTO comments (text, book_id)
VALUES ('not good', 1)