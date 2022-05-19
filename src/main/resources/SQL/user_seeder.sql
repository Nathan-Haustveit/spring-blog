USE spring_blog_db;

INSERT INTO users(email, username, password)
VALUES ('chris@email.com', 'crispy', 'password'),
       ('oscar@email.com', 'o-man', 'password'),
       ('justin@codeup.com', 'j-bomb', 'password');

INSERT INTO post(title, body, user_id)
VALUES ('Test', 'This is just a test.', 1),
       ('Another Test', 'Yet another test.', 2),
       ('Third Test', 'You know the drill.', 3);