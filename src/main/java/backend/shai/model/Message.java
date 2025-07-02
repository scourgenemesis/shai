package backend.shai.model;

import java.time.LocalDateTime;


public class Message {
    private String content;
    private Long id;
    private User sender;
    private User recipient;
    private LocalDateTime timestamp;
    private MessageStatus MessageStatus;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public MessageStatus getMessageStatus() {
        return MessageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        MessageStatus = messageStatus;
    }

    public enum MessageStatus {
        SENT, DELIVERED, READ
    }
}
