ALTER TABLE messages
ADD COLUMN status VARCHAR(20) NOT NULL DEFAULT 'SENT';  -- 'SENT', 'DELIVERED', 'READ'


CREATE INDEX idx_messages_status ON messages(status);

CREATE TABLE read_receipts (
    id BIGSERIAL PRIMARY KEY,
    message_id BIGINT NOT NULL REFERENCES messages(id),
    user_id BIGINT NOT NULL REFERENCES users(id),
    read_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    UNIQUE (message_id, user_id)  -- Prevent duplicates
);  