package backend.shai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "message")
public class Message {
    private String content;
    @Id @GeneratedValue
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

    public User getRecipient() {
        return recipient;
    }
    
    public void setSender(User sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
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
