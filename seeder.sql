USE spring_blog_db;

INSERT INTO post_details (history_of_post, is_awesome, topic_description)
    VALUES ('random', TRUE, 'general');

INSERT INTO post (title, body, post_details_id)
VALUES ('A post', 'this is my post', 1);