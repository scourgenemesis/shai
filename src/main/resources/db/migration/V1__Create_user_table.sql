CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE messages (
    id SERIAL PRIMARY KEY,
    context TEXT NOT NULL,
    sender_id INTEGER_PREFERENCES users(id),
    chat_id INTEGER_PREFERENCES chats(id),
    status VARCHAR(20) DEFAULT "SENT",
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);


CREATE TABLE chats (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(50) NOT NULL,
    created_by BIGINT NOT NULL PREFERENCES users(id),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    last_message_at TIMESTAMP WITH TIME ZONE
);


CREATE TABLE chat_participants (
    chat_id BIGINT NOT NULL REFERENCES chats(id),
    user_id BIGINT NOT NULL REFERENCES users(id),
    joined_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    PRIMARY KEY (chat_id, user_id)
);

CREATE INDEX idx_messages_chat_id ON messages(chat_id);
CREATE INDEX idx_messages_sender_id ON messages(sender_id);
CREATE INDEX idx_chat_participants_user_id ON chat_participants(user_id);