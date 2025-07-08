CREATE TABLE chat_message(
    id VARCHAR(255) NOT NULL PRIMARY KEY UNIQUE,
    content VARCHAR(1000) NOT NULL,
    sending_time DATETIME NOT NULL,
    sender_id VARCHAR(255) NOT NULL,
    chat_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_sender_id FOREIGN KEY (sender_id) REFERENCES user(id),
    CONSTRAINT fk_chat_id FOREIGN KEY (chat_id) REFERENCES chat_server(id)
)