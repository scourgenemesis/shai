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
)


CREATE TABLE chats (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(50) NOT NULL;
);

