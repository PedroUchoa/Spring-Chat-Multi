CREATE TABLE user_chat(
    user_id VARCHAR(255) NOT NULL,
    chat_server_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_chat_server_id FOREIGN KEY (chat_server_id) REFERENCES chat_server(id)
)